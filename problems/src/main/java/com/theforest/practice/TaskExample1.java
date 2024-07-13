package com.theforest.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskExample1 {

    /*
        Есть мультимапа
        1 -> [0, 1, 2]
        2 -> [3, 4]
        Требуется: развернуть мапу с использованием StreamAPI
                    (можем считать, что коллизий не возникает)
        0 -> 1; 1 -> 1; 2 -> 1; 3 -> 2; 4 -> 2;
     */

    public static void main(String[] args) {
        Map<Integer, List<Long>> inputMap = new HashMap<>();
        inputMap.put(1, Arrays.asList(0L, 1L, 2L));
        inputMap.put(2, Arrays.asList(3L, 4L));

        Map<Long, Integer> outputMapVer1 = inputMap.entrySet()
                .stream()
                .flatMap(it -> it.getValue().stream())
                .collect(Collectors.toMap(
                        key -> key,
                        value -> inputMap.keySet()
                                .stream()
                                .filter(keyMap -> inputMap.get(keyMap)
                                .contains(value))
                                .findFirst()
                                .orElseThrow()));

        Map<Long, Integer> outputMapVer2 = inputMap.entrySet()
                .stream()
                .flatMap(entry -> {
                    Integer key = entry.getKey();
                    List<Long> value = entry.getValue();
                    return value.stream().map(val -> Map.entry(val, key));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println("ver1 " + outputMapVer1);
        System.out.println("ver1 " + outputMapVer2);

    }
}
