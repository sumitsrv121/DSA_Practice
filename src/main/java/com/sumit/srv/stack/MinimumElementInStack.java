package com.sumit.srv.stack;

import java.util.Stack;

public class MinimumElementInStack {
    private static final Stack<Integer> stack = new Stack<>();
    private static int min;

    public static void main(String[] args) {
        int[] arr = {18, 19, 29, 15, 15, 16};

        for (int val : arr) {
            push(val);
        }
        int minValue = minElement();
        int poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);

        minValue = minElement();
        poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);

        minValue = minElement();
        poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);


        minValue = minElement();
        poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);


        minValue = minElement();
        poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);

        minValue = minElement();
        poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);

        minValue = minElement();
        poppedValue = pop();
        System.out.println("Popped value: " + poppedValue + " Min value: " + minValue);

    }

    private static int pop() {
        if (stack.empty()) {
            return -1;
        }
        if (stack.peek() >= min) {
            return stack.pop();
        } else {
            // 2*min -x
            int x = stack.pop();
            int currentMin = min;
            min = 2 * min - x;
            return currentMin;
        }
    }

    private static void push(int val) {
        if (stack.empty()) {
            min = val;
            stack.push(val);
        } else {
            if (val < min) {
                // 2X - Min
                stack.push(2 * val - min);
                min = val;
            } else {
                stack.push(val);
            }
        }
        System.out.println("Stack till now " + stack);
    }

    private static int minElement() {
        if (stack.empty()) {
            return -1;
        }
        return min;
    }

}
