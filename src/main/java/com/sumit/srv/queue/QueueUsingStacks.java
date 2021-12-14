package com.sumit.srv.queue;

import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        System.out.println(pollFromQueue(s1, s2));
        for (int i = 1; i <= 10; i++) {
            addInQueue(i, s1);
            if (i == 5) {
                System.out.println(pollFromQueue(s1, s2));

            }
        }
        System.out.println(pollFromQueue(s1, s2));
        System.out.println(pollFromQueue(s1, s2));
        System.out.println(pollFromQueue(s1, s2));
        System.out.println(pollFromQueue(s1, s2));

    }

    private static int pollFromQueue(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.empty()) {
            return -1;
        }
        while (s1.size() > 1) {
            s2.add(s1.pop());
        }
        int val = s1.pop();
        while (!s2.isEmpty()) {
            s1.add(s2.pop());
        }
        return val;
    }

    private static void addInQueue(int i, Stack<Integer> stack) {
        stack.push(i);
    }
}
