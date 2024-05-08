package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;

public class ConsoleLogger {
    public void log(String message, Level level) {
        String output = Formatter.getFormatedOutput(message, level);
        System.out.println(output);
    }
}
