package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

public class SequencePatternMatching {
    public static void main(String[] args) {
        String x = "AXY";
        String y = "ADXCPY";

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[x.length()][y.length()];
        System.out.println(lcs == x.length());
    }
}
