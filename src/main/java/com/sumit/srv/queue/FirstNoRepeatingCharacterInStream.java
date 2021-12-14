package com.sumit.srv.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FirstNoRepeatingCharacterInStream {
    public static void main(String[] args) {
        String str = "abcbbac";
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                Integer val = map.get(c);
                if (val == 1) {
                    queue.remove(c);
                }
                map.put(c, val + 1);
            } else {
                map.put(c, 1);
                queue.offer(c);
            }
            if (queue.isEmpty()) {
                builder.append('#');
            } else {
                builder.append(queue.peekFirst());
            }
            System.out.println(queue);
        }
        System.out.println(builder);

    }
}
