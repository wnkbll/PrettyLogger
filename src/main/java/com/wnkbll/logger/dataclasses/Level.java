package com.wnkbll.logger.dataclasses;

import java.util.HashMap;

public class Level {
    public String name;
    public Format format = new Format();

    public Level(String name, String style, String foreground, String background) {
        this.name = name;

        HashMap<String, Integer> styles = Globals.getStyles();
        HashMap<String, Integer> colors = Globals.getColors();

        if (style != null) this.format.style = styles.get(style);
        if (foreground != null) this.format.foreground = colors.get(foreground);
        if (background != null) this.format.background = colors.get(background) + 10;
    }
}
