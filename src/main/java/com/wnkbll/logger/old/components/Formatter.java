package com.wnkbll.logger.old.components;

import com.wnkbll.logger.old.dataclasses.Format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {
    public static String getFormatedTime(String pattern) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

        return currentTime.format(format);
    }

    public static String colorize(String text, Format format) {
        return String.format(
                "\033[%s;%s;%sm%s\033[0m",
                format.style,
                format.foreground,
                format.background,
                text
        );
    }
}
