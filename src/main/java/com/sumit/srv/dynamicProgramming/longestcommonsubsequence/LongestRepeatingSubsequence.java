package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String x = "AABEBCDD";


        int[][] t = new int[x.length() + 1][x.length() + 1];
        for (int i = 0; i < t.length; i++) {
            t[i][0] = 0;
        }

        for (int i = 1; i < t[0].length; i++) {
            t[0][i] = 0;
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(t));
        int i = x.length();
        int j = x.length();
        StringBuilder builder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == x.charAt(j - 1) && i != j) {
                builder.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println(builder.reverse());
    }
}
