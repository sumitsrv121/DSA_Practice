package com.sumit.srv.dynamicProgramming.longestincreasingsubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};

        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maximumLength = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (maximumLength < dp[i]) {
                maximumLength = dp[i];
                maxIndex = i;
            }
        }

        StringBuilder builder = new StringBuilder();
        int l = maximumLength;
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == l) {
                builder.append(arr[i]).append("-");
                l--;
            }
            if (l == 0) {
                break;
            }
        }

        System.out.println(builder);
        System.out.println(maximumLength);
        System.out.println(Arrays.toString(dp));
    }
}
