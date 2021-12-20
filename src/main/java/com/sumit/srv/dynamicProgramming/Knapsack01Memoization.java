package com.sumit.srv.dynamicProgramming;

import java.util.Arrays;

public class Knapsack01Memoization {
    private static int[][] t;

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;
        t = new int[capacity + 1][wt.length + 1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }
        int profit = findMaximumProfit(wt, val, capacity, wt.length);
        System.out.println("Maximum profit : " + profit);
        System.out.println(Arrays.deepToString(t));
    }

    private static int findMaximumProfit(int[] wt, int[] val, int capacity, int n) {
        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (t[capacity][n] != -1) {
            System.out.println(n + "  " + capacity);
            return t[capacity][n];
        }

        if (wt[n - 1] > capacity) {
            return t[capacity][n] = findMaximumProfit(wt, val, capacity, n - 1);
        } else {
            return t[capacity][n] = Math.max(val[n - 1] + findMaximumProfit(wt, val, capacity - wt[n - 1], n - 1),
                    findMaximumProfit(wt, val, capacity, n - 1));
        }
    }
}
