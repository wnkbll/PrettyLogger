package com.wnkbll.logger.types;

public class Text {
    public String text;
    public OutputFormat format;

    public Text(String text, OutputFormat format) {
        this.text = text;
        this.format = format;
    }

    @Override
    public String toString() {
        return text;
    }
}
