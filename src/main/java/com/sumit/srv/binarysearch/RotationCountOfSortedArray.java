package com.sumit.srv.binarysearch;

public class RotationCountOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {15, 2, 5, 6, 8, 11, 12};
        int ans = countRotation(arr, 0, arr.length - 1);
        System.out.println(ans);
    }

    private static int countRotation(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;

        if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid;
        } else if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid + 1;
        } else if (arr[mid] < arr[start]) {
            return countRotation(arr, start, mid - 1);
        } else {
            return countRotation(arr, mid + 1, end);
        }
    }
}
