package com.sumit.srv.dynamicProgramming;

import java.util.Arrays;

public class CountNumberOfSubsetWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        int sum = Arrays.stream(arr).sum();
        // s1 = (sum+diff)/2

        int s = (sum + diff) / 2;

        // problem is now count the number of subset with given sum i.e. s

        int[][] dp = new int[arr.length + 1][s + 1];
        // s = 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // n = 0
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        System.out.println(dp[arr.length][s]);
    }
}
