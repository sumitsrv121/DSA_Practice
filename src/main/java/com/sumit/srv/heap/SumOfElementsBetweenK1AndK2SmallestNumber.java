package com.sumit.srv.heap;

import java.util.PriorityQueue;

public class SumOfElementsBetweenK1AndK2SmallestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 5, 15, 11};
        int k1 = 3;
        int k2 = 6;

        int k = Math.max(k1, k2);
        int j = Math.min(k1, k2);
        int sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        for (int val : arr) {
            maxHeap.add(val);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while (maxHeap.size() > j) {
            if (maxHeap.size() != k) {
                sum += maxHeap.peek();
            }
            maxHeap.poll();
        }

        System.out.println(sum);
    }
}
