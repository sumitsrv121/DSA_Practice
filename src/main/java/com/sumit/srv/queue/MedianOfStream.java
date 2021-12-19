package com.sumit.srv.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianOfStream {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 7, 1, 5, 6, 8};
        int[] median = new int[arr.length];

        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

        int j = 0;
        for (int val : arr) {
            if (leftMaxHeap.isEmpty() && rightMinHeap.isEmpty()) {
                leftMaxHeap.add(val);
                median[j++] = val;
                continue;
            } else if (leftMaxHeap.size() > rightMinHeap.size() && leftMaxHeap.peek() > val) {
                Integer pollValue = leftMaxHeap.poll();
                leftMaxHeap.add(val);
                rightMinHeap.add(pollValue);
            } else if (leftMaxHeap.size() > rightMinHeap.size() && leftMaxHeap.peek() < val) {
                rightMinHeap.add(val);
            } else if (leftMaxHeap.size() == rightMinHeap.size() && leftMaxHeap.peek() < val && rightMinHeap.peek() > val) {
                leftMaxHeap.add(val);
            } else if (leftMaxHeap.size() == rightMinHeap.size() && val > rightMinHeap.peek()) {
                Integer poll = rightMinHeap.poll();
                leftMaxHeap.add(poll);
                rightMinHeap.add(val);
            } else if (leftMaxHeap.size() == rightMinHeap.size() && val < leftMaxHeap.peek()) {
                leftMaxHeap.add(val);
            } else if (leftMaxHeap.size() > rightMinHeap.size() && val == leftMaxHeap.peek()) {
                rightMinHeap.add(val);
            } else if (leftMaxHeap.size() == rightMinHeap.size() && val == leftMaxHeap.peek()) {
                leftMaxHeap.add(val);
            } else if (leftMaxHeap.size() == rightMinHeap.size() && val > leftMaxHeap.peek()) {
                leftMaxHeap.add(val);
            } else {
                System.out.println(val + " Hit else condition");
            }


            if (leftMaxHeap.size() == rightMinHeap.size()) {
                median[j++] = (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
            } else {
                median[j++] = leftMaxHeap.peek();
            }
        }
        System.out.println(Arrays.toString(median));
    }
}
