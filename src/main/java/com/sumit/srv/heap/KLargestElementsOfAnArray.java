package com.sumit.srv.heap;

import java.util.PriorityQueue;

public class KLargestElementsOfAnArray {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + "--->");
        }
    }
}
