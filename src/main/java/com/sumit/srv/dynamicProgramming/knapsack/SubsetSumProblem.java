package com.sumit.srv.dynamicProgramming.knapsack;

import java.util.Arrays;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 14;
        // find if there is any subset will the given sum present in array or not

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        String[][] path = new String[arr.length + 1][sum + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
            path[0][i] = null;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
            path[i][0] = "0";
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                    path[i][j] = path[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    if (!dp[i - 1][j] && dp[i - 1][j - arr[i - 1]]) {
                        path[i][j] = path[i - 1][j - arr[i - 1]] + "---->" + arr[i - 1];
                    } else if (dp[i - 1][j]) {
                        path[i][j] = path[i - 1][j];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        System.out.println(Arrays.deepToString(path));
        System.out.println(dp[arr.length][sum]);
    }

    /* public static boolean isValidSubset(int[] arr, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (arr[n - 1] > sum) {
            return isValidSubset(arr, sum, n - 1);
        } else {
            return isValidSubset(arr, sum, n - 1) || isValidSubset(arr, sum - arr[n - 1], n - 1);
        }
    }*/
}
