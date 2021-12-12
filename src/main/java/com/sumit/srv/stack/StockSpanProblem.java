package com.sumit.srv.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] ans = new int[arr.length];

        Stack<Entry> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek().getValue() <= arr[i]) {
                stack.pop();
            }

            if (stack.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek().getPosition();
            }
            stack.push(new Entry(i, arr[i]));
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i - ans[i];
        }

        System.out.println(Arrays.toString(ans));
    }
}
