package com.sumit.srv.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencySort {
    private static int i = 0;

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 4, 3, 2, 2, 4, 3};

        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((e1, e2) -> Integer.compare(e2, e1)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
        int[] ans = new int[arr.length];
        sortedMap.entrySet().forEach(e -> {
            int key = e.getKey();
            for (int j = 0; j < e.getValue(); j++) {
                ans[i++] = key;
            }
        });
        System.out.println(Arrays.toString(ans));
    }
}
