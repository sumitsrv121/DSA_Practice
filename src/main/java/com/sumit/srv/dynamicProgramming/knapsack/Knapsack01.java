package com.sumit.srv.dynamicProgramming.knapsack;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int capacity = 7;

        int maxProfit = findMaximumProfit(wt, val, capacity, val.length);
        System.out.println(maxProfit);

    }

    private static int findMaximumProfit(int[] wt, int[] val, int capacity, int n) {
        if (capacity == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] > capacity) {
            return findMaximumProfit(wt, val, capacity, n - 1);
        } else {
            return Math.max(val[n - 1] + findMaximumProfit(wt, val, capacity - wt[n - 1], n - 1),
                    findMaximumProfit(wt, val, capacity, n - 1));
        }
    }
}
