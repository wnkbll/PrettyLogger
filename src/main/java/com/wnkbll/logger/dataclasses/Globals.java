package com.wnkbll.logger.dataclasses;

import java.util.HashMap;

public class Globals {
    public static HashMap<String, Integer> getStyles() {
        HashMap<String, Integer> styles = new HashMap<>();
        styles.put("normal", 0);
        styles.put("bold", 1);
        styles.put("dim", 2);
        styles.put("italic", 3);
        styles.put("underline", 4);
        styles.put("blink", 5);

        return styles;
    }

    public static HashMap<String, Integer> getColors() {
        HashMap<String, Integer> colors = new HashMap<>();
        colors.put("black", 30);
        colors.put("red", 31);
        colors.put("green", 32);
        colors.put("yellow", 33);
        colors.put("blue", 34);
        colors.put("magenta", 35);
        colors.put("cyan", 36);
        colors.put("white", 37);
        colors.put("reset", 39);

        return colors;
    }

    public static HashMap<String, Level> getLevels() {
        HashMap<String, Level> levels = new HashMap<>();
        levels.put("trace", new Level("trace", "normal", "cyan", "reset"));
        levels.put("debug", new Level("debug", "normal", "blue", "reset"));
        levels.put("info", new Level("info", "normal", "reset", "reset"));
        levels.put("success", new Level("success", "normal", "green", "reset"));
        levels.put("warning", new Level("warning", "normal", "yellow", "reset"));
        levels.put("error", new Level("error", "normal", "red", "reset"));
        levels.put("critical", new Level("critical", "bold", "red", "reset"));

        return levels;
    }

    public static HashMap<String, Integer> getPostfixMultipliers() {
        HashMap<String, Integer> table = new HashMap<>();
        table.put("B", 1);
        table.put("KB", 1000);
        table.put("MB", 1000000);
        table.put("GB", 1000000000);

        return table;
    }
}
