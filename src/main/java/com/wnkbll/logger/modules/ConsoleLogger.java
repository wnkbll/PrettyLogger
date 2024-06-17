package com.wnkbll.logger.modules;

import com.wnkbll.logger.types.Text;

public class ConsoleLogger {
    public void log(Text time, Text level, Text trace, Text message) {
        String output = Formatter.getColorizedOutput(time, level, trace, message);
        System.out.println(output);
    }
}
