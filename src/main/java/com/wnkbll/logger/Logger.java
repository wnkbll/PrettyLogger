package com.wnkbll.logger;

import com.wnkbll.logger.modules.Adapter;

public final class Logger {
    private static final Adapter adapter = new Adapter();

    public static int DEBUG = 1;
    public static int INFO = 2;
    public static int SUCCESS = 3;
    public static int WARNING = 4;
    public static int ERROR = 5;
    public static int CRITICAL = 6;

    public static void setMinLevel(int value) {
        adapter.setMinLevel(value);
    }

    public static void debug(String message) {
        adapter.debug(message);
    }

    public static void info(String message) {
        adapter.info(message);
    }

    public static void success(String message) {
        adapter.success(message);
    }

    public static void warning(String message) {
        adapter.warning(message);
    }

    public static void error(String message) {
        adapter.error(message);
    }

    public static void critical(String message) {
        adapter.critical(message);
    }
}
