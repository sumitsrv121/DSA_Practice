package com.sumit.srv.binarysearch;

public class ElementThatAppearsOnceInSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 3, 7, 7, 10, 11, 11};
        int index = findUniqueElement(arr, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int findUniqueElement(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (mid % 2 == 0) {
            if (mid > 0 && arr[mid] == arr[mid - 1]) {
                return findUniqueElement(arr, start, mid - 2);
            } else if (mid < arr.length - 1 && arr[mid] == arr[mid + 1]) {
                return findUniqueElement(arr, mid + 2, end);
            } else {
                return mid;
            }
        } else {
            if (mid > 0 && arr[mid] == arr[mid - 1]) {
                return findUniqueElement(arr, mid + 1, end);
            } else if (mid < arr.length - 1 && arr[mid] == arr[mid + 1]) {
                return findUniqueElement(arr, start, mid - 1);
            } else {
                return mid;
            }
        }
    }
}
