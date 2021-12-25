package com.sumit.srv.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 0, 17, 17, 20};
        int n = 8;
        int[][] dp = new int[price.length][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], 0);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (length[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

    /* private static int findMaximumProfit(int[] length, int[] price, int sum, int n) {
        if (sum == 0 || n == 0) {
            return 0;
        }
        if (length[n - 1] > sum) {
            return findMaximumProfit(length, price, sum, n - 1);
        } else {
            return Math.max(findMaximumProfit(length, price, sum, n - 1),
                    price[n - 1] + findMaximumProfit(length, price, sum - length[n - 1], n));
        }
    }*/
}
