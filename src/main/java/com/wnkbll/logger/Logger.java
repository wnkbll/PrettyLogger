package com.wnkbll.logger;

import com.wnkbll.logger.components.FileStream;
import com.wnkbll.logger.components.Formatter;
import com.wnkbll.logger.components.Parser;
import com.wnkbll.logger.dataclasses.Format;
import com.wnkbll.logger.dataclasses.Globals;
import com.wnkbll.logger.dataclasses.Level;
import com.wnkbll.logger.dataclasses.Pair;
import com.wnkbll.logger.interfaces.ILogger;

import java.io.IOException;
import java.util.HashMap;

public class Logger implements ILogger {
    private final HashMap<String, Level> levels = Globals.getLevels();

    private int rotation = 0;

    public void setRotation(String value) {
        if (Parser.isMatched(value, "\\d+[A-Za-z]{1,2}")) {
            Pair<String, String> pair = Parser.getRotationInfo(value);
            HashMap<String, Integer> multipliers = Globals.getPostfixMultipliers();

            if (multipliers.containsKey(pair.second.toUpperCase())) {
                this.rotation = Integer.parseInt(pair.first) * multipliers.get(pair.second.toUpperCase());
            }
        }
    }

    private void log(Level level, String message) {
        String timePattern = "YYYY-MM-dd HH:mm:ss.SSS";
        String messagePattern = "%s | %s | %s - %s";
        String tracePattern = "%s:%s:%s";

        Format timeFormat = new Format(0, 32, 49);
        Format traceFormat = new Format(0, 36, 49);

        String _time = Formatter.getFormatedTime(timePattern);
        String _level = level.name.toUpperCase() + " ".repeat(8 - level.name.length());

        String _trace = String.format(
                tracePattern,
                Thread.currentThread().getStackTrace()[3].getClassName(),
                Thread.currentThread().getStackTrace()[3].getMethodName(),
                Thread.currentThread().getStackTrace()[3].getLineNumber()
        );

        String colorizedTime = Formatter.colorize(_time, timeFormat);
        String colorizedLevel = Formatter.colorize(_level, level.format);
        String colorizeTrace = Formatter.colorize(_trace, traceFormat);
        String colorizedMessage = Formatter.colorize(message, level.format);

        String output = String.format(
                messagePattern,
                colorizedTime, colorizedLevel, colorizeTrace, colorizedMessage
        );

        String logMessage = String.format(
                messagePattern,
                _time, _level, _trace, message
        );

        System.out.println(output);

        try {
            FileStream fileStream = new FileStream("logs", "file", this.rotation);
            fileStream.write(logMessage);
        } catch (IOException ignored) {
            System.out.println("Impossible to write .log file.");
        }
    }

    @Override
    public void trace(String message) {
        this.log(levels.get("trace"), message);
    }

    @Override
    public void debug(String message) {
        this.log(levels.get("debug"), message);
    }

    @Override
    public void info(String message) {
        this.log(levels.get("info"), message);
    }

    @Override
    public void success(String message) {
        this.log(levels.get("success"), message);
    }

    @Override
    public void warning(String message) {
        this.log(levels.get("warning"), message);
    }

    @Override
    public void error(String message) {
        this.log(levels.get("error"), message);
    }

    @Override
    public void critical(String message) {
        this.log(levels.get("critical"), message);
    }
}
