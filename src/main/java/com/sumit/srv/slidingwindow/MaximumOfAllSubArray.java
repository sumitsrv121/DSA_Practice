package com.sumit.srv.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubArray {
    public static void main(String[] args) {
        List<Integer> al = List.of(1, 3, -1, -3, 5, 3, 6, 7);
        int k = 3;
        ArrayList<Integer> ans = new ArrayList<>();

        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (max < al.get(i)) {
                max = al.get(i);
            }
        }
        int end = k + start - 1;
        while (end < al.size()) {
            ans.add(max);
            end++;
            start++;
            if (end < al.size()) {
                if (al.get(start - 1) == max) {
                    if (al.get(end) > max) {
                        max = al.get(end);
                    } else {
                        max = Integer.MIN_VALUE;
                        for (int i = start; i <= end; i++) {
                            if (max < al.get(i)) {
                                max = al.get(i);
                            }
                        }
                    }
                }
                if (al.get(end) > max) {
                    max = al.get(end);
                }
            }
        }

        System.out.println(ans);
    }
}
