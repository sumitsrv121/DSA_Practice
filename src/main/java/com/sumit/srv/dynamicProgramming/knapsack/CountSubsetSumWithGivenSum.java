package com.sumit.srv.dynamicProgramming.knapsack;

import java.util.Arrays;

public class CountSubsetSumWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;

        int[][] dp = new int[arr.length + 1][sum + 1];

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[arr.length][sum]);
    }

    /* public static int countSubsetSum(int[] arr, int sum, int n) {
        if (n == 0 && sum == 0) {
            return 1;
        }

        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (arr[n - 1] > sum) {
            return countSubsetSum(arr, sum, n - 1);
        } else {
            return countSubsetSum(arr, sum, n - 1) + countSubsetSum(arr, sum - arr[n - 1], n - 1);
        }
    } */
}
