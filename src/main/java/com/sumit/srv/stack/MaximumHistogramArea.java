package com.sumit.srv.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaximumHistogramArea {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        List<Element> ans = new ArrayList<>();

        Stack<Entry> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek().getValue() >= arr[i]) {
                stack.pop();
            }
            Element e = new Element();
            if (stack.empty()) {
                e.setRightIndex(arr.length);
            } else {
                e.setRightIndex(stack.peek().getPosition());
            }
            e.setHeight(arr[i]);
            ans.add(e);
            stack.push(new Entry(i, arr[i]));
        }
        Collections.reverse(ans);
        
        stack.clear();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek().getValue() >= arr[i]) {
                stack.pop();
            }
            Element e = ans.get(i);
            if (stack.empty()) {
                e.setLeftIndex(-1);

            } else {
                e.setLeftIndex(stack.peek().getPosition());
            }
            ans.set(i, e);
            stack.push(new Entry(i, arr[i]));
        }

        ans.stream()
                .map(e -> (e.getRightIndex() - e.getLeftIndex() - 1) * e.getHeight())
                .max(Integer::compare).ifPresent(System.out::println);
    }
}
