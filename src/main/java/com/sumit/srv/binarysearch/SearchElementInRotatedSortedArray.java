package com.sumit.srv.binarysearch;

public class SearchElementInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {11, 12, 15, 18, 19, 20, 21, 2, 5, 6, 8};
        int key = 11;

        int pivot = findPivotIndex(arr, 0, arr.length - 1);
        System.out.println("pivot ----> " + pivot);
        int index;
        if (pivot == -1) {
            // Array is not rotated
            // do binary search
            index = binarySearch(arr, 0, arr.length - 1, key);
        } else {
            if (arr[pivot] == key) {
                System.out.println(pivot);
                return;
            } else if (arr[0] <= key && arr[pivot] > key) {
                // binary search in first half
                index = binarySearch(arr, 0, pivot - 1, key);
            } else {
                // binary search in second half
                index = binarySearch(arr, pivot + 1, arr.length - 1, key);
            }
        }
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearch(arr, start, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, end, key);
        }
    }

    private static int findPivotIndex(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[start] > arr[mid]) {
            return findPivotIndex(arr, start, mid - 1);
        } else {
            return findPivotIndex(arr, mid + 1, end);
        }
    }
}
