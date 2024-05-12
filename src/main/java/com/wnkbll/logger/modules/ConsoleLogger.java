package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;
import com.wnkbll.logger.interfaces.Logger;

public class ConsoleLogger implements Logger {
    public void log(String message, Level level) {
        String output = Formatter.getFormatedOutput(message, level);
        System.out.println(output);
    }
}
