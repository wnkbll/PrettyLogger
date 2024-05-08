package com.wnkbll.logger.old.components;

import com.wnkbll.logger.old.dataclasses.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static String getSubstring(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) return matcher.group();

        return null;
    }

    private static String[] getSubstrings(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) return pattern.split(string);
        return null;
    }

    public static boolean isMatched(String string, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(string);

        if (matcher.find()) return matcher.group(0).equals(string);

        return false;
    }

    public static Pair<String, String> getRotationInfo(String rotation) {
        Pair<String, String> pair = new Pair<>();

        pair.first = getSubstring(rotation, "\\d+");
        pair.second = getSubstring(rotation, "[A-Za-z]{1,2}");

        return pair;
    }

    public static void parse() {
        String s = "<green>{time: YYYY-MM-dd HH:mm:ss.SSS}</green> | <level>{level}</level> | <cyan>{trace: class:func:line}</cyan> - <level>{message}</level>";
        String regex = "<\\w{3,7}>\\{[\\w\\s:.-]+\\}<\\/\\w{3,7}>";
        String[] strings = getSubstrings(s, regex);
        assert strings != null;
        System.out.println(strings[0]);
    }
}
