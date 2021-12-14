package com.sumit.srv.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsInQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int k = 1;
        for (int i = 1; i <= 1; i++) {
            queue.offer(i);
        }
        System.out.println(queue);
        reverseKElements(queue, k, queue.size());
        System.out.println(queue);
    }

    private static void reverseKElements(Queue<Integer> queue, int k, int n) {
        Stack<Integer> stack = new Stack<>();
        // empty k elements from queue into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        // push it back in the queue
        while (!stack.empty()) {
            queue.offer(stack.pop());
        }
        for (int i = 0; i < n - k; i++) {
            queue.offer(queue.poll());
        }
    }

}
