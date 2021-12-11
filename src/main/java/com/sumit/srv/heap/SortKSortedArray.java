package com.sumit.srv.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};

        int k = 3;
        int i = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int val : arr) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                arr[i++] = minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }

        System.out.println(Arrays.toString(arr));
    }
}
