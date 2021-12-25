package com.sumit.srv.dynamicProgramming;

import java.util.Arrays;

public class MinimumSubsetSumDifference {

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        int sum = Arrays.stream(arr).sum();
        int min = Integer.MAX_VALUE;
        // Range ----> 0 to sum
        // s1 and s2 will lie between 0 to sum
        // 0 and null will be always there check from 1 to n-1
        int maxSum = sum;
        sum = sum / 2;

        boolean[][] t = new boolean[arr.length + 1][sum + 1];

        // n = 0 and sum = 0 then true
        // n = 0 and sum != 0 then false
        // sum = 0 then true
        for (int i = 0; i < t.length; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i < t[0].length; i++) {
            t[0][i] = false;
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                }
            }
        }
        for (int i = 1; i < t[arr.length].length; i++) {
            if (t[arr.length][i] && min > Math.abs(2 * i - maxSum)) {
                min = Math.abs(2 * i - maxSum);
            }
        }
        System.out.println(min);

    }

    /* private static boolean isSubsetSumPresent(int[] arr, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (arr[n - 1] > sum) {
            return isSubsetSumPresent(arr, sum, n - 1);
        } else {
            return isSubsetSumPresent(arr, sum - arr[n - 1], n - 1) || isSubsetSumPresent(arr, sum, n - 1);
        }
    } */
}
