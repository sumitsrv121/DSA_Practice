package com.sumit.srv.heap;

import java.util.PriorityQueue;

public class ConnectingRopes {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 5, 2};
        int totalCost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            minHeap.add(val);
        }

        while (minHeap.size() > 1) {
            int min = minHeap.poll();
            Integer poll = minHeap.poll();
            int secondMin = poll == null ? 0 : poll;
            int result = min + secondMin;
            totalCost += result;
            minHeap.add(result);
        }

        System.out.println(totalCost);
    }
}
