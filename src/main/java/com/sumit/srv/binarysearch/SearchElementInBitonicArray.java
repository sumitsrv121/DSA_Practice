package com.sumit.srv.binarysearch;

public class SearchElementInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        int key = 4;

        int peakIndex = findPeakIndex(arr);
        System.out.println(peakIndex);
        if (peakIndex != -1) {
            if (arr[peakIndex] == key) {
                System.out.println("Peak element found at the index " + peakIndex);
            }
            if (arr[peakIndex] > key) {
                int index = binarySearch(arr, 0, peakIndex - 1, key);
                if (index != -1) {
                    System.out.println(index);
                    return;
                }
            }
            if (arr[peakIndex] > key && arr[arr.length - 1] <= key) {
                int index = binarySearchInDescendingArray(arr, peakIndex + 1, arr.length - 1, key);
                if (index != -1) {
                    System.out.println(index);
                    return;
                }
            }
        }
        System.out.println("Not found");
    }

    private static int binarySearchInDescendingArray(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return binarySearchInDescendingArray(arr, mid + 1, end, key);
        } else {
            return binarySearchInDescendingArray(arr, start, mid - 1, key);
        }
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

    private static int findPeakIndex(int[] arr) {
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
