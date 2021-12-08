package com.sumit.srv.binarysearch;

public class BinarySearchOnDescendingSortedArray {
    public static void main(String[] args) {
        int[] arr = {20, 17, 15, 14, 13, 12, 10, 9, 8, 4, 2};
        int key = 17;
        int index = binarySearchUsingRecursion(arr, 0, arr.length - 1, key);
        System.out.println(index);
        index = binarySearchUsingIteration(arr, key);
        System.out.println(index);
    }

    private static int binarySearchUsingIteration(int[] arr, int key) {
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

    private static int binarySearchUsingRecursion(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearchUsingRecursion(arr, mid + 1, end, key);
        } else {
            return binarySearchUsingRecursion(arr, start, mid - 1, key);
        }
    }
}
