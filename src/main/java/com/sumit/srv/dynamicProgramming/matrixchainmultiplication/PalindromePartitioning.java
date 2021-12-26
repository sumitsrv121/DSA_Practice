package com.sumit.srv.dynamicProgramming.matrixchainmultiplication;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String x = "abcde";

        int partitions = findMinimumPartition(x, 0, x.length() - 1);
        System.out.println(partitions);
    }

    private static int findMinimumPartition(String x, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(x, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = findMinimumPartition(x, i, k) + findMinimumPartition(x, k + 1, j) + 1;
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    private static boolean isPalindrome(String x, int i, int j) {
        while (i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
