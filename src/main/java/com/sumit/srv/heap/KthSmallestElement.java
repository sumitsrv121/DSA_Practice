package com.sumit.srv.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e1 < e2 ? 1 : (e1.equals(e2)) ? 0 : -1);

        for (int j : arr) {
            maxHeap.add(j);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        System.out.println(maxHeap.peek());
    }
}
