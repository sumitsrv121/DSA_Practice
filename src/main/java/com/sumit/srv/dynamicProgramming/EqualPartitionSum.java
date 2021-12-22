package com.sumit.srv.dynamicProgramming;

import java.util.Arrays;

public class EqualPartitionSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int sum = Arrays.stream(arr).sum();
        int s;
        if (sum % 2 == 0) {
            s = sum / 2;
        } else {
            System.out.println(false);
            return;
        }
        boolean[][] dp = new boolean[arr.length + 1][s + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = false;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[arr.length][s]);
    }

    /* private static boolean isEqualSumSubset(int[] arr, int leftSum, int rightSum, int n) {
        if (leftSum == rightSum) {
            return true;
        }
        if (n == 0 && rightSum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (leftSum <= rightSum) {
            return isEqualSumSubset(arr, leftSum, rightSum, n - 1)
                    || isEqualSumSubset(arr, leftSum + arr[n - 1],
                    rightSum - arr[n - 1], n - 1);
        } else {
            return isEqualSumSubset(arr, leftSum, rightSum, n - 1);
        }
    }*/
}
