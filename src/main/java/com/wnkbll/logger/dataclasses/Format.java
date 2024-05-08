package com.wnkbll.logger.dataclasses;

public class Format {
    public int style = 0;
    public int foreground = 0;
    public int background = 0;

    public Format() {

    }

    public Format(int style, int foreground, int background) {
        this.style = style;
        this.foreground = foreground;
        this.background = background;
    }
}
