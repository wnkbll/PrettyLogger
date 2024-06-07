package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Text;
import com.wnkbll.logger.dataclasses.OutputFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {
    public static Text equalizeLevelName(Text level) {
        return new Text(level.text + " ".repeat(8 - level.text.length()), level.format);
    }

    public static Text getTime(String pattern) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);

        OutputFormat outputFormat = new OutputFormat(0, 36, 49);

        return new Text(currentTime.format(format), outputFormat);
    }

    public static Text getTrace(String pattern) {
        int length = Thread.currentThread().getStackTrace().length - 1;

        StackTraceElement currentStackTrace = Thread.currentThread().getStackTrace()[length];
        String className = currentStackTrace.getClassName();
        String methodName = currentStackTrace.getMethodName();
        String lineNumber = String.valueOf(currentStackTrace.getLineNumber());

        String trace = String.format(
                pattern,
                className, methodName, lineNumber
        );

        OutputFormat outputFormat = new OutputFormat(0, 32, 49);

        return new Text(trace, outputFormat);
    }

    public static String colorize(Text text) {
        return String.format(
                "\033[%s;%s;%sm%s\033[0m",
                text.format.style,
                text.format.foreground,
                text.format.background,
                text
        );
    }

    public static String getFormatedOutput(Text time, Text level, Text trace, Text message) {
        String outputPattern = "%s | %s | %s - %s";

        return  String.format(
                outputPattern,
                time, equalizeLevelName(level),
                trace, message
        );
    }

    public static String getColorizedOutput(Text time, Text level, Text trace, Text message) {
        String outputPattern = "%s | %s | %s - %s";

        return  String.format(
                outputPattern,
                colorize(time), colorize(equalizeLevelName(level)),
                colorize(trace), colorize(message)
        );
    }
}
