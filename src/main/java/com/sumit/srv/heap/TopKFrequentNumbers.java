package com.sumit.srv.heap;

import java.util.*;

public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 2, 4, 4, 4, 4, 4, 6, 6};
        int k = 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        map.entrySet().forEach(e -> {
            minHeap.add(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });
        int[] ans = new int[k];
        int i = k - 1;
        while (!minHeap.isEmpty()) {
            ans[i--] = minHeap.poll().getKey();
        }

        System.out.println(Arrays.toString(ans));

    }
}
