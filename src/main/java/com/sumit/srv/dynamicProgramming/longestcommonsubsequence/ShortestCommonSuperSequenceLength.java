package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

import java.util.Arrays;

public class ShortestCommonSuperSequenceLength {
    public static void main(String[] args) {
        String x = "geek";
        String y = "eke";

        // lcs start
        int[][] t = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i < t.length; i++) {
            t[i][0] = 0;
        }

        for (int i = 1; i < t[0].length; i++) {
            t[0][i] = 0;
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(t));

        int lengthOfCommonSuperSequence = x.length() + y.length() - t[x.length()][y.length()];
        System.out.println(lengthOfCommonSuperSequence);
    }
}
