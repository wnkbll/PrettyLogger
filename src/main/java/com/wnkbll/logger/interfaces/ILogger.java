package com.wnkbll.logger.interfaces;

public interface ILogger {
    void trace(String message);

    void debug(String message);

    void info(String message);

    void success(String message);

    void warning(String message);

    void error(String message);

    void critical(String message);
}
