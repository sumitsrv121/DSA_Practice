package com.sumit.srv.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = binarySearchUsingRecursion(arr, 0, arr.length - 1, 10);
        System.out.println(index);
        index = binarySearchUsingIteration(arr, 11);
        System.out.println(index);
    }

    private static int binarySearchUsingIteration(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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

    private static int binarySearchUsingRecursion(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearchUsingRecursion(arr, start, mid - 1, key);
        } else {
            return binarySearchUsingRecursion(arr, mid + 1, end, key);
        }
    }
}
