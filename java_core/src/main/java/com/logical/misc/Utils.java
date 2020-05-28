package com.logical.misc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Utils {

    public static <E, K> Map<K, List<E>> groupBy(Iterable<E> iterable, Function<E, K> fn) {
        Map<K, List<E>> map = new LinkedHashMap<>();
        for (E item : iterable) {
            K key = fn.apply(item);
            if (map.containsKey(key)) {
                List<E> val = map.get(key);
                val.add(item);
                map.put(key, val);
            } else {
                List<E> val = new ArrayList<>();
                val.add(item);
                map.put(key, val);
            }
        }
        return map;
    }

    public static <E, K> Map<K, List<E>> groupByStream(Iterable<E> iterable, Function<E, K> key) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.groupingBy(key));
    }

    public static String reverse(String str) {
        if (str.length() == 0) {
            return str;
        }
        return reverse(str.substring(1)) + str.substring(0, 1);
    }

}
