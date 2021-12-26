package com.sumit.srv.dynamicProgramming.matrixchainmultiplication;

import java.util.Arrays;

public class PalindromePartitionMemoization {
    private static int[][] dp;

    public static void main(String[] args) {
        String x = "ababbbabbababa";

        dp = new int[x.length() + 1][x.length() + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int val = findNumberOfPartitions(x, 0, x.length() - 1);
        System.out.println(val);
    }

    private static int findNumberOfPartitions(String x, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(x, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k <= j; k++) {
            int temp = findNumberOfPartitions(x, i, k - 1) + findNumberOfPartitions(x, k, j) + 1;
            if (temp < min) {
                min = temp;
                dp[i][j] = min;
            }
        }
        return min;
    }

    private static boolean isPalindrome(String x, int i, int j) {
        while (i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
