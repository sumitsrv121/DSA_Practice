package com.sumit.srv.binarysearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        // In this sorting order of the array will be not mentioned
        // you will have to figure it out
        int[] arr = {-1, -1, 1, 1, 1, 1};
        int[] arr1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        int index;
        int key = -1;
        // find sorting order of array
        if (arr[0] == arr[arr.length - 1]) {
            // only 1 element is getting repeated as the array is sorted
            // so just compare and return no need to go for binary search
            index = arr[0] == key ? 0 : -1;
        } else if (arr[0] > arr[arr.length - 1]) {
            // descending sort
            index = binarySearchForDescendingSortedArray(arr, key);
        } else {
            // ascending sort
            index = binarySearchForAscendingSortedArray(arr, key);
        }

        System.out.println(index);
        // find sorting order of another array
        if (arr1[0] == arr1[arr1.length - 1]) {
            // only 1 element is getting repeated as the array is sorted
            // so just compare and return no need to go for binary search
            index = arr1[0] == key ? 0 : -1;
        } else if (arr1[0] > arr1[arr1.length - 1]) {
            // descending sort
            index = binarySearchForDescendingSortedArray(arr1, key);
        } else {
            // ascending sort
            index = binarySearchForAscendingSortedArray(arr1, key);
        }
        System.out.println(index);
    }

    private static int binarySearchForAscendingSortedArray(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    private static int binarySearchForDescendingSortedArray(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
