package com.sumit.srv.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class CoinChangeMaximumNumberOfWays {
    public static void main(String[] args) {
        int sum = 5;
        int[] arr = {1, 2, 3};

        int[][] dp = new int[arr.length + 1][sum + 1];
        // sum = 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // n = 0
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
    }
}
