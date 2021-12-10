package com.sumit.srv.binarysearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 3, 2};
        int key = findPeakElement(arr);
        System.out.println(arr[key]);
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
                } else if (arr[mid] < arr[mid - 1]) {
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
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    return mid - 1;
                }
            }
        }
        return 0;
    }
}
