package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;
import com.wnkbll.logger.dataclasses.OutputFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {
    private static String getTimeFromPattern(String pattern) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

        return currentTime.format(format);
    }

    private static String colorize(String text, OutputFormat format) {
        return String.format(
                "\033[%s;%s;%sm%s\033[0m",
                format.style,
                format.foreground,
                format.background,
                text
        );
    }

    private static String getFormatedTime() {
        String timePattern = "YYYY-MM-dd HH:mm:ss.SSS";
        OutputFormat format = new OutputFormat(0, 32, 49);
        String time = getTimeFromPattern(timePattern);

        return colorize(time, format);
    }

    private static String getFormatedLevel(Level level) {
        return colorize(level.name + " ".repeat(8-level.name.length()), level.format);
    }

    private static String getFormatedTrace() {
        String tracePattern = "%s:%s:%s";
        OutputFormat format = new OutputFormat(0, 36, 49);

        int length = Thread.currentThread().getStackTrace().length - 1;
        String className = colorize(Thread.currentThread().getStackTrace()[length].getClassName(), format);
        String methodName = colorize(Thread.currentThread().getStackTrace()[length].getMethodName(), format);
        String lineNumber = colorize(String.valueOf(Thread.currentThread().getStackTrace()[length].getLineNumber()), format);

        return String.format(
                tracePattern,
                className, methodName, lineNumber
        );
    }

    private static String getFormatedMessage(String message, Level level) {
        return colorize(message, level.format);
    }

    public static String getFormatedOutput(String message, Level level) {
        String outputPattern = "%s | %s | %s - %s";

        return  String.format(
                outputPattern,
                getFormatedTime(), getFormatedLevel(level),
                getFormatedTrace(), getFormatedMessage(message, level)
        );
    }
}
