package com.sumit.srv.slidingwindow;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1, 2, 3, 5};
        int sum = 5;

        int start = 0;
        int end = 0;
        int currentSum = 0;
        int maxLength = Integer.MIN_VALUE;
        while (end < arr.length) {
            if (currentSum == sum) {
                if (maxLength < end - start + 1) {
                    maxLength = end - start + 1;
                }
                start++;
                end++;
                if (end < arr.length)
                    currentSum = currentSum - arr[start - 1] + arr[end];
            } else if (currentSum < sum) {
                end++;
                if (end < arr.length) {
                    currentSum += arr[end];
                }
            } else {
                currentSum -= arr[start];
                start++;
            }
        }
        System.out.println(maxLength);
    }
}
