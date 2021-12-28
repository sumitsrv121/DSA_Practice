package com.sumit.srv.slidingwindow;

public class FindMaximumSumSubset {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;

        int start = 0;
        int end = start + k - 1;

        int kthSum = 0;
        for (int i = 0; i < k; i++) {
            kthSum += arr[i];
        }

        int maxSum = kthSum;

        start++;
        end++;
        while (end < arr.length) {
            kthSum = kthSum + arr[end] - arr[start - 1];
            if (kthSum > maxSum) {
                maxSum = kthSum;
            }
            start++;
            end++;
        }
        System.out.println(maxSum);
    }
}
