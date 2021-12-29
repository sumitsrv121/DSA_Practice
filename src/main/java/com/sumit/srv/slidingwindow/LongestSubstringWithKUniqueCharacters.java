package com.sumit.srv.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String s = "aaaabc";
        int k = 2;

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int maxLen = -1;
        while (j < s.length()) {
            // calculation
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            } else {
                map.put(s.charAt(j), 1);
            }

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                if (maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                }
                j++;
            } else {
                // map.size() > k
                while (map.size() > k) {
                    if (map.get(s.charAt(i)) > 1) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    } else {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                if (map.size() == k) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                    }
                }
                j++;
            }
        }
        System.out.println(maxLen);
    }
}
