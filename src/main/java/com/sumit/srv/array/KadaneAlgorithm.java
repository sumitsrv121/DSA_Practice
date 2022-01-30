package com.sumit.srv.array;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int s = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (maxSum < currSum) {
                start = s;
                end = i;
                maxSum = currSum;
            }
            if (currSum < 0) {
                s = i + 1;
                currSum = 0;
            }
        }
        System.out.println("start " + start + " end " + end);
        System.out.println(maxSum);
    }
}
