package com.sumit.srv.binarysearch;

public class FirstAndLastIndexOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        int key = 20;
        int index;
        index = findFirstIndex(arr, key);
        System.out.println(index);
        index = findLastIndex(arr, key);
        System.out.println(index);
    }

    private static int findLastIndex(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int lastIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                lastIndex = mid;
                start = mid + 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return lastIndex;
    }

    private static int findFirstIndex(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int firstIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                firstIndex = mid;
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstIndex;
    }
}
