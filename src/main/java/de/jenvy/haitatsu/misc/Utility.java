package de.jenvy.haitatsu.misc;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    Utility() {
        Channel channel = null;
    }

    public static final String DEFAULT_DELIMITER = "::";

    public static String listToString(List<?> list) {
        return listToString(list, DEFAULT_DELIMITER);
    }

    public static String listToString(List<?> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    public static List<String> stringToList(String compressed) {
        return stringToList(compressed, DEFAULT_DELIMITER);
    }

    public static List<String> stringToList(String compressed, String delimiter) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, compressed.split(delimiter));
        return list;
    }

}
