package com.sumit.srv.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetElement {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};

        int k = 3;
        int x = 7;

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getKey(), e1.getKey()));
        for (int val : arr) {
            maxHeap.add(new Pair(Math.abs(x - val), val));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] ans = new int[maxHeap.size()];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i++] = maxHeap.poll().getValue();
        }

        System.out.println(Arrays.toString(ans));
    }
}
