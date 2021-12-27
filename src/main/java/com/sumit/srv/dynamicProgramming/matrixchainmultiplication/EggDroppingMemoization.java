package com.sumit.srv.dynamicProgramming.matrixchainmultiplication;

import java.util.Arrays;

public class EggDroppingMemoization {
    private static int[][] dp;

    public static void main(String[] args) {
        int floors = 5;
        int egg = 3;

        dp = new int[egg + 1][floors + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ways = findNumberOfWays(egg, floors);
        System.out.println(ways);
    }

    private static int findNumberOfWays(int egg, int floors) {
        if (egg == 1) {
            return floors;
        }
        if (floors == 1 || floors == 0) {
            return floors;
        }
        if (dp[egg][floors] != -1) {
            return dp[egg][floors];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            int temp = 1 + Math.max(findNumberOfWays(egg - 1, i - 1),
                    findNumberOfWays(egg, floors - i));
            if (temp < min) {
                min = temp;
                dp[egg][floors] = min;
            }
        }
        return min;
    }
}
