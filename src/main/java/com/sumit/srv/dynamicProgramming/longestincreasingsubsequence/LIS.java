package com.sumit.srv.dynamicProgramming.longestincreasingsubsequence;

import java.util.Arrays;

public class LIS {
    private static int[][] dp;

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        dp = new int[arr.length + 1][arr.length + 1];

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        System.out.println(lisHelper(arr, arr.length, -1));
    }

    private static int lisHelper(int[] arr, int n, int prev) {
        if (n == 0) {
            return 0;
        }
        if (prev != -1 && dp[n][prev] != -1) {
            return dp[n][prev];
        }
        int ops = 0;
        if (prev == -1 || arr[n - 1] < arr[prev - 1]) {
            ops = 1 + lisHelper(arr, n - 1, n);
        }
        int ops1 = lisHelper(arr, n - 1, prev);
        if (prev != -1) {
            dp[n][prev] = Math.max(ops, ops1);
        }
        return Math.max(ops, ops1);
    }
}
