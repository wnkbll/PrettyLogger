package com.wnkbll.logger.dataclasses;

public class Level {
    public String name;
    public OutputFormat format = new OutputFormat();

    public Level(String name, int style, int foreground, int background) {
        this.name = name;
        this.format.style = style;
        this.format.foreground = foreground;
        this.format.background = background;
    }
}
