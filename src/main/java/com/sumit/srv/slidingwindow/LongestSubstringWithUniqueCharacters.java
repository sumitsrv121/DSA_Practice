package com.sumit.srv.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithUniqueCharacters {
    public static void main(String[] args) {
        String x = "pwwkew";

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int start = 0;
        int end = 0;
        int maxLen = -1;
        while (end < x.length()) {
            // calculation
            if (map.containsKey(x.charAt(end))) {
                map.put(x.charAt(end), map.get(x.charAt(end)) + 1);
            } else {
                map.put(x.charAt(end), 1);
            }
            count++;

            if (count < map.size()) {
                end++;
            } else if (count == map.size()) {
                if (maxLen < count) {
                    maxLen = count;
                }
                end++;
            } else {
                // remove element from start side
                while (count > map.size()) {
                    if (map.get(x.charAt(start)) > 1) {
                        map.put(x.charAt(start), map.get(x.charAt(start)) - 1);
                    } else {
                        map.remove(x.charAt(start));
                    }
                    count--;
                    start++;
                }
                if (count == map.size()) {
                    if (maxLen < count) {
                        maxLen = count;
                    }
                }
                end++;
            }
        }
        System.out.println(maxLen);
    }
}
