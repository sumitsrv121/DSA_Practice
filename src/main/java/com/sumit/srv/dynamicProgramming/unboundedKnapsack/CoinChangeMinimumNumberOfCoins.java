package com.sumit.srv.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class CoinChangeMinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1, 11};
        int sum = 11;
        int[][] dp = new int[coins.length + 1][sum + 1];

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int noOfCoins = findMinimumNumberOfCoins(coins, sum, coins.length);
        System.out.println(noOfCoins);
    }

    private static int findMinimumNumberOfCoins(int[] coins, int sum, int n) {
        if (sum == 0) {
            return 0;
        }
        if (n == 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (coins[n - 1] > sum) {
            return findMinimumNumberOfCoins(coins, sum, n - 1);
        } else {
            return Math.min(findMinimumNumberOfCoins(coins, sum, n - 1), 1 + findMinimumNumberOfCoins(coins, sum - coins[n - 1], n));
        }
    }
}
