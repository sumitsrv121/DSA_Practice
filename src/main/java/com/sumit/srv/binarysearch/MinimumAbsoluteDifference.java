package com.sumit.srv.binarysearch;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 12, 15};
        int key = -1;

        int ans = findMinimumAbsoluteDifference(arr, key);
        System.out.println(ans);
    }

    private static int findMinimumAbsoluteDifference(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int index = -1;
        int k = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (index != -1) {
            return arr[index];
        }
        int min = Integer.MAX_VALUE;
        if (start < arr.length && min > Math.abs(arr[start] - key)) {
            min = Math.abs(arr[start] - key);
            k = arr[start];
        }

        if (end >= 0 && min > Math.abs(arr[end] - key)) {
            k = arr[end];
        }
        return k;
    }
}
