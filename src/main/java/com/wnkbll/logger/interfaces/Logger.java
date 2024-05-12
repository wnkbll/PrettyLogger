package com.wnkbll.logger.interfaces;

import com.wnkbll.logger.dataclasses.Level;

public interface Logger {
    void log(String message, Level level);
}
