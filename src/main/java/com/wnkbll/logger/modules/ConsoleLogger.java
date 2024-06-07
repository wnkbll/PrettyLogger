package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Text;
import com.wnkbll.logger.interfaces.Logger;

public class ConsoleLogger implements Logger {
    public void log(Text time, Text level, Text trace, Text message) {
        String output = Formatter.getColorizedOutput(time, level, trace, message);
        System.out.println(output);
    }
}
