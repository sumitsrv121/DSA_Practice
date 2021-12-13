package com.sumit.srv.stack;

import java.util.PriorityQueue;

public class StackUsingPriorityQueue {
    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getKey(), e1.getKey()));

        for (int entry : arr) {
            maxHeap.add(new Pair(count++, entry));
        }
        System.out.println(maxHeap);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll().getValue());
        }
    }
}
