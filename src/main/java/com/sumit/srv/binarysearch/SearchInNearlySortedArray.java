package com.sumit.srv.binarysearch;

public class SearchInNearlySortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 30, 20, 40};
        int key = 10;
        int index = binarySearch(arr, key);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (mid > start && arr[mid - 1] == key) {
                return mid - 1;
            } else if (mid < end && arr[mid + 1] == key) {
                return mid + 1;
            } else if (arr[mid] >= key) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }
        return -1;
    }
}
