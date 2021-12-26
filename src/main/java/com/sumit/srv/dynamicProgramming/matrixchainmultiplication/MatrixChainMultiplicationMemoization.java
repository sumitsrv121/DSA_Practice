package com.sumit.srv.dynamicProgramming.matrixchainmultiplication;

import java.util.Arrays;

public class MatrixChainMultiplicationMemoization {
    private static int[][] dp;

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};

        /*
         * A1 --> 40*20 (0,1)
         * A2 --> 20*30 (1,2)
         * A3 --> 30*10 (2,3)
         * A4 --> 10*30 (3,4)
         * Ai --> (i-1, i)
         * */
        dp = new int[arr.length + 1][arr.length + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int minCost = findMinimumCost(arr, 1, arr.length - 1);
        System.out.println(minCost);
        System.out.println(Arrays.deepToString(dp));
    }

    private static int findMinimumCost(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k <= j; k++) {
            int temp = findMinimumCost(arr, i, k - 1) + findMinimumCost(arr, k, j) + arr[i - 1] * arr[k - 1] * arr[j];
            if (temp < min) {
                min = temp;
                dp[i][j] = min;
            }
        }
        return min;
    }
}
