package com.sumit.srv.stack;

import java.util.Stack;

public class LongestValidParentheses {
    private static final Stack<Character> stack = new Stack<>();
    private static final Stack<Integer> indexStack = new Stack<>();
    private static int count = 0;

    public static void main(String[] args) {
        indexStack.push(-1);
        String str = "())";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                // push
                push(c, i);
            } else if (c == ')') {
                // pop
                pop(i);
            }
        }
        System.out.println(count);
    }

    private static void pop(int index) {
        if (stack.empty()) {
            indexStack.push(index);
        } else {
            stack.pop();
            indexStack.pop();
            count = Math.max(count, index - indexStack.peek());
        }
    }

    private static void push(char c, int index) {
        stack.push(c);
        indexStack.push(index);
    }
}
