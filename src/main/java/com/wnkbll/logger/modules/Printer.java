package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;

public class Printer {
    private void log(String message, Level level) {
        String output = Formatter.getFormatedOutput(message, level);
        System.out.println(output);
    }

    public void debug(String message) {
        log(message, new Level("DEBUG", 0, 34, 49));
    }

    public void info(String message) {
        log(message, new Level("INFO", 0, 39, 49));
    }

    public void success(String message) {
        log(message, new Level("SUCCESS", 0, 32, 49));
    }

    public void warning(String message) {
        log(message, new Level("WARNING", 0, 33, 49));
    }

    public void error(String message) {
        log(message, new Level("ERROR", 0, 31, 49));
    }

    public void critical(String message) {
        log(message, new Level("CRITICAL", 1, 31, 49));
    }
}
