package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

import java.util.Arrays;

public class MinimumNumberOfDeletionToMakeItAPalindrome {
    public static void main(String[] args) {
        String x = "geeksforgeeks";
        String y = new StringBuilder(x).reverse().toString();

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        int noOfDeletion = x.length() - dp[x.length()][y.length()];
        System.out.println(noOfDeletion);
    }
}
