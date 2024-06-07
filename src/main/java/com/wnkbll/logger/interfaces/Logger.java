package com.wnkbll.logger.interfaces;

import com.wnkbll.logger.dataclasses.Text;

public interface Logger {
    void log(Text time, Text level, Text trace, Text message);
}
