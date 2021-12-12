package com.sumit.srv.stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] ans = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(ans));
    }
}
