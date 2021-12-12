package com.sumit.srv.stack;

import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class MaximumAreaRectangleInBinaryMatrix {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int[] histogram = new int[arr[0].length];

        System.arraycopy(arr[0], 0, histogram, 0, histogram.length);
        maximumAreaHistogram(histogram).ifPresent(e -> {
            if (max < e) {
                max = e;
            }
        });
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    histogram[j] = 0;
                } else {
                    histogram[j] += arr[i][j];
                }
            }
            maximumAreaHistogram(histogram).ifPresent(e -> {
                if (max < e) {
                    max = e;
                }
            });
        }
        System.out.println(max);
    }

    private static Optional<Integer> maximumAreaHistogram(int[] arr) {
        Element[] ans = new Element[arr.length];
        Stack<Entry> stack = new Stack<>();

        // Nearest smallest element to left
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek().getValue() >= arr[i]) {
                stack.pop();
            }
            Element e = new Element();
            if (stack.empty()) {
                e.setLeftIndex(-1);
            } else {
                e.setLeftIndex(stack.peek().getPosition());
            }
            e.setHeight(arr[i]);
            ans[i] = e;
            stack.push(new Entry(i, arr[i]));
        }

        stack.clear();
        // Nearest smallest element to right
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek().getValue() >= arr[i]) {
                stack.pop();
            }
            Element e = ans[i];
            if (stack.empty()) {
                e.setRightIndex(arr.length);
            } else {
                e.setRightIndex(stack.peek().getPosition());
            }
            ans[i] = e;
            stack.push(new Entry(i, arr[i]));
        }

        return Arrays.stream(ans)
                .map(e -> (e.getRightIndex() - e.getLeftIndex() - 1) * e.getHeight())
                .max(Integer::compare);
    }
}
