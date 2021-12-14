package com.sumit.srv.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestNumberInStream {
    public static void main(String[] args) {
        int[] arr = {3, 4};
        int k = 1;
        List<Integer> al = new LinkedList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
                al.add(minHeap.peek());
            } else if (minHeap.size() == k) {
                al.add(minHeap.peek());
            } else {
                al.add(-1);
            }
        }

        System.out.println(al);
    }
}
