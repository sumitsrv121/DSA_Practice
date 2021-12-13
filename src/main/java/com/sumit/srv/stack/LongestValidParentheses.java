package com.sumit.srv.stack;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int count = 0;
        indexStack.push(-1);
        String str = ")()())()";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                // push
                stack.push(i);
                indexStack.push(i);
            } else if (c == ')') {
                // pop
                if (stack.empty()) {
                    indexStack.push(i);
                } else {
                    stack.pop();
                    indexStack.pop();
                    count = Math.max(count, i - indexStack.peek());
                }
            }
        }
        System.out.println(count);
    }
}
