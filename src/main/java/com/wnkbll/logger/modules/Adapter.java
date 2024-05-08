package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;

public class Adapter {
    private final FileLogger file = new FileLogger();
    private final ConsoleLogger console = new ConsoleLogger();

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

    public void debug(String message) {
        Level level = new Level("DEBUG", 0, 34, 49);
        console.log(message, level);

        if (MIN_LEVEL <= DEBUG)
            file.log(message, level);
    }

    public void info(String message) {
        Level level = new Level("INFO", 0, 39, 49);
        console.log(message, level);

        if (MIN_LEVEL <= INFO)
            file.log(message, level);
    }

    public void success(String message) {
        Level level = new Level("SUCCESS", 0, 32, 49);
        console.log(message, level);

        if (MIN_LEVEL <= SUCCESS)
            file.log(message, level);
    }

    public void warning(String message) {
        Level level = new Level("WARNING", 0, 33, 49);
        console.log(message, level);

        if (MIN_LEVEL <= WARNING)
            file.log(message, level);
    }

    public void error(String message) {
        Level level = new Level("ERROR", 0, 31, 49);
        console.log(message, level);

        if (MIN_LEVEL <= ERROR)
            file.log(message, level);
    }

    public void critical(String message) {
        Level level = new Level("CRITICAL", 1, 31, 49);
        console.log(message, level);

        if (MIN_LEVEL <= CRITICAL)
            file.log(message, level);
    }
}
