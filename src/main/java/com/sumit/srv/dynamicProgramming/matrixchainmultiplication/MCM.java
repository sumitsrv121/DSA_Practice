package com.sumit.srv.dynamicProgramming.matrixchainmultiplication;

public class MCM {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 30};
        int cost = findMinimumMultiplicationCost(arr, 1, arr.length - 1);
        System.out.println(cost);
    }

    private static int findMinimumMultiplicationCost(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = findMinimumMultiplicationCost(arr, i, k)
                    + findMinimumMultiplicationCost(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            if (minCost > temp) {
                minCost = temp;
            }
        }
        return minCost;
    }
}
