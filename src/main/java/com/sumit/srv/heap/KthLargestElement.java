package com.sumit.srv.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int j : arr) {
            minHeap.add(j);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        System.out.println(minHeap.peek());
    }
}
