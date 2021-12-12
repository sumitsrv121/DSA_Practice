package com.sumit.srv.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerElementToRight {
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 0, 2, 2, 4};
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i]) {
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
