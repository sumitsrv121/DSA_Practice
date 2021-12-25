package com.sumit.srv.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class CoinChangeMaximumNumberOfWaysWithNoTwosTogether {

    public static void main(String[] args) {
        int sum = 8;
        long[] dp = new long[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 3];
            }
        }
        System.out.println(Arrays.toString(dp));
        long ways = findMaximumWays(sum, 0);
        System.out.println(ways);
    }

    private static long findMaximumWays(int sum, int prev) {
        if (sum == 0) {
            return 1;
        }

        if (sum < 2) {
            return findMaximumWays(sum - 1, 1);
        } else {
            if (prev == 2) {
                return findMaximumWays(sum - 1, 1);
            } else {
                return findMaximumWays(sum - 1, 1) + findMaximumWays(sum - 2, 2);
            }
        }
    }
}
