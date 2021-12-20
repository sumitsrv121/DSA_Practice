package com.sumit.srv.dynamicProgramming;

import java.util.Arrays;

public class Knapsack01TopDown {

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int capacity = 7;
        int n = val.length;

        int[][] t = new int[n + 1][capacity + 1];

        for (int i = 0; i < t.length; i++) {
            t[i][0] = 0;
        }

        Arrays.fill(t[0], 0);

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if (wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(t));
        System.out.println(t[val.length][capacity]);
    }
}
