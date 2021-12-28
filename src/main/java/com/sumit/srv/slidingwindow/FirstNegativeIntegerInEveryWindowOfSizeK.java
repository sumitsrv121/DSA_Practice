package com.sumit.srv.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -5, 30, 16, 28};
        int k = 3;

        int noOfWindows = arr.length - k + 1;
        int[] ans = new int[noOfWindows];
        List<Integer> indexNegative = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                indexNegative.add(i);
            }
        }

        int start = 0;
        int end = k + start - 1;
        int l = 0;
        int window = 0;
        while (end < arr.length) {
            if (l < indexNegative.size() && indexNegative.get(l) < start + k) {
                if (start < indexNegative.get(l)) {
                    ans[window++] = arr[indexNegative.get(l)];
                } else if (start == indexNegative.get(l)) {
                    ans[window++] = arr[indexNegative.get(l)];
                    l++;
                }
            } else {
                ans[window++] = 0;
            }
            end++;
            start++;
        }

        System.out.println(Arrays.toString(ans));
    }
}
