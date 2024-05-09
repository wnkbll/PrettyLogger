package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;

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

    public void setMinLevel(Integer value) {
        MIN_LEVEL = value;
    }

    public void setFileLogger(FileLogger logger) {
        fileLogger = logger;
    }

    public void debug(String message) {
        Level level = new Level("DEBUG", 0, 34, 49);
        consoleLogger.log(message, level);

        if (MIN_LEVEL <= DEBUG)
            fileLogger.log(message, level);
    }

    public void info(String message) {
        Level level = new Level("INFO", 0, 39, 49);
        consoleLogger.log(message, level);

        if (MIN_LEVEL <= INFO)
            fileLogger.log(message, level);
    }

    public void success(String message) {
        Level level = new Level("SUCCESS", 0, 32, 49);
        consoleLogger.log(message, level);

        if (MIN_LEVEL <= SUCCESS)
            fileLogger.log(message, level);
    }

    public void warning(String message) {
        Level level = new Level("WARNING", 0, 33, 49);
        consoleLogger.log(message, level);

        if (MIN_LEVEL <= WARNING)
            fileLogger.log(message, level);
    }

    public void error(String message) {
        Level level = new Level("ERROR", 0, 31, 49);
        consoleLogger.log(message, level);

        if (MIN_LEVEL <= ERROR)
            fileLogger.log(message, level);
    }

    public void critical(String message) {
        Level level = new Level("CRITICAL", 1, 31, 49);
        consoleLogger.log(message, level);

        if (MIN_LEVEL <= CRITICAL)
            fileLogger.log(message, level);
    }
}
