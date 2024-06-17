package com.wnkbll.logger.modules;

import com.wnkbll.logger.types.Text;
import com.wnkbll.logger.types.OutputFormat;

import java.util.HashMap;

public class Adapter {
    private FileLogger fileLogger = new FileLogger();
    private final ConsoleLogger consoleLogger = new ConsoleLogger();

    private static final int DEBUG = 1;
    private static final int INFO = 2;
    private static final int SUCCESS = 3;
    private static final int WARNING = 4;
    private static final int ERROR = 5;
    private static final int CRITICAL = 6;

    private static int MIN_LEVEL = DEBUG;

    private static final HashMap<String, Integer> LEVELS = new HashMap<>();

    public Adapter() {
        LEVELS.put("DEBUG", DEBUG);
        LEVELS.put("INFO", INFO);
        LEVELS.put("SUCCESS", SUCCESS);
        LEVELS.put("WARNING", WARNING);
        LEVELS.put("ERROR", ERROR);
        LEVELS.put("CRITICAL", CRITICAL);
    }

    public void setMinLevel(Integer value) {
        MIN_LEVEL = value;
    }

    public void setFileLogger(FileLogger logger) {
        fileLogger = logger;
    }

    private void log(Text message, Text level) {
        Text time = Formatter.getTime("YYYY-MM-dd HH:mm:ss.SSS");
        Text trace = Formatter.getTrace("%s:%s:%s");

        consoleLogger.log(time, level, trace, message);

         if (MIN_LEVEL <= LEVELS.get(level.text))
            fileLogger.log(time, level, trace, message);
    }

    public void debug(String message) {
        OutputFormat format = new OutputFormat(0, 34, 49);

        Text level = new Text("DEBUG", format);
        Text logMessage = new Text(message, format);

        log(logMessage, level);
    }

    public void info(String message) {
        OutputFormat format = new OutputFormat(0, 39, 49);

        Text level = new Text("INFO", format);
        Text logMessage = new Text(message, format);

        log(logMessage, level);
    }

    public void success(String message) {
        OutputFormat format = new OutputFormat(0, 32, 49);

        Text level = new Text("SUCCESS", format);
        Text logMessage = new Text(message, format);

        log(logMessage, level);
    }

    public void warning(String message) {
        OutputFormat format = new OutputFormat(0, 33, 49);

        Text level = new Text("WARNING", format);
        Text logMessage = new Text(message, format);

        log(logMessage, level);
    }

    public void error(String message) {
        OutputFormat format = new OutputFormat(0, 31, 49);

        Text level = new Text("ERROR", format);
        Text logMessage = new Text(message, format);

        log(logMessage, level);
    }

    public void critical(String message) {
        OutputFormat format = new OutputFormat(1, 31, 49);

        Text level = new Text("CRITICAL", format);
        Text logMessage = new Text(message, format);

        log(logMessage, level);
    }
}
