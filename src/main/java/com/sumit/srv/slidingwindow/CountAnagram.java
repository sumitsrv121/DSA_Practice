package com.sumit.srv.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountAnagram {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mainMap = new HashMap<>();

        for (int i = 0; i < pat.length(); i++) {
            if (map.containsKey(pat.charAt(i))) {
                map.put(pat.charAt(i), map.get(pat.charAt(i)) + 1);
            } else {
                map.put(pat.charAt(i), 1);
            }
        }


        int k = pat.length();
        for (int i = 0; i < k; i++) {
            if (mainMap.containsKey(txt.charAt(i))) {
                mainMap.put(txt.charAt(i), mainMap.get(txt.charAt(i)) + 1);
            } else {
                mainMap.put(txt.charAt(i), 1);
            }
        }

        int start = 0;
        int end = k + start - 1;
        int n = txt.length();

        int count = 0;
        while (end < n) {
            if (isAnagram(map, mainMap)) {
                count++;
            }
            end++;
            start++;
            if (end < n) {
                if (mainMap.get(txt.charAt(start - 1)) > 1) {
                    mainMap.put(txt.charAt(start - 1), mainMap.get(txt.charAt(start - 1)) - 1);
                } else {
                    mainMap.remove(txt.charAt(start - 1));
                }

                if (mainMap.containsKey(txt.charAt(end))) {
                    mainMap.put(txt.charAt(end), mainMap.get(txt.charAt(end)) + 1);
                } else {
                    mainMap.put(txt.charAt(end), 1);
                }
            }

        }
        System.out.println(count);
    }

    private static boolean isAnagram(Map<Character, Integer> map, Map<Character, Integer> mainMap) {
        return map.entrySet().stream()
                .noneMatch(e -> !mainMap.containsKey(e.getKey()) || !Objects.equals(mainMap.get(e.getKey()), map.get(e.getKey())));
    }
}
