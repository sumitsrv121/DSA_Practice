package com.sumit.srv.stack;

import java.util.Stack;

public class MinStackUsingExtraSpace {
    public static void main(String[] args) {
        int[] arr = {18, 19, 29, 15, 16};

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        push(arr, stack, minStack);
        System.out.println(stack);
        pop(stack, minStack);
        System.out.println(minElement(minStack));
        System.out.println(stack);
        pop(stack, minStack);
        System.out.println(minElement(minStack));
        System.out.println(stack);
        pop(stack, minStack);
        System.out.println(minElement(minStack));
        System.out.println(stack);
        pop(stack, minStack);
        System.out.println(minElement(minStack));
        System.out.println(stack);
        pop(stack, minStack);
        System.out.println(minElement(minStack));
    }

    private static void pop(Stack<Integer> stack, Stack<Integer> minStack) {
        if (!stack.empty() && !minStack.empty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    private static void push(int[] arr, Stack<Integer> stack, Stack<Integer> minStack) {
        for (int j : arr) {
            stack.push(j);
            if (minStack.empty() || minStack.peek() >= j) {
                minStack.push(j);
            }
        }
    }

    private static int minElement(Stack<Integer> minStack) {
        if (!minStack.empty()) {
            return minStack.peek();
        }
        return -1;
    }
}
