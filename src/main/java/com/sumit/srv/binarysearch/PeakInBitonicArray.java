package com.sumit.srv.binarysearch;

public class PeakInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 9, 10, 11, 12, 4, 2};
        int peak = findPeakElement(arr);
        if (peak != -1)
            System.out.println(arr[peak]);
        else
            System.out.println("Unable to find peak");
    }

    private static int findPeakElement(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    return mid - 1;
                }
            }
        }
        return -1;
    }
}
