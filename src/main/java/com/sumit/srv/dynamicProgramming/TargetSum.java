package com.sumit.srv.dynamicProgramming;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int sum = 1;

        int totalSumOfArray = Arrays.stream(arr).sum();

        // this problem is same as count the no. of subset with given diff
        int s = (sum + totalSumOfArray) / 2;
        int[][] dp = new int[arr.length + 1][s + 1];

        // n = 0
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        // s = 0
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
        System.out.println(dp[arr.length][s]);
    }
}
