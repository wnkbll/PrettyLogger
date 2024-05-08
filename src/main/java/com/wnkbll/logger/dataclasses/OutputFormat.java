package com.wnkbll.logger.dataclasses;

public class OutputFormat {
    public int style = 0;
    public int foreground = 39;
    public int background = 49;

    public OutputFormat() {

    }

    public OutputFormat(int style, int foreground, int background) {
        this.style = style;
        this.foreground = foreground;
        this.background = background;
    }
}
