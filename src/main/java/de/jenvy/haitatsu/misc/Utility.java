package de.jenvy.haitatsu.misc;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    public static final String DEFAULT_DELIMITER = "::";

    Utility() {
    }

    @NotNull
    public static String listToString(@NotNull List<?> list) {
        return listToString(list, DEFAULT_DELIMITER);
    }

    @NotNull
    public static String listToString(@NotNull List<?> list, String delimiter) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    @NotNull
    public static List<String> stringToList(@NotNull String compressed) {
        return stringToList(compressed, DEFAULT_DELIMITER);
    }

    @NotNull
    public static List<String> stringToList(@NotNull String compressed, @NotNull String delimiter) {
        var list = new ArrayList<String>();
        Collections.addAll(list, compressed.split(delimiter));
        return list;
    }

}
