package com.sumit.srv.binarysearch;

public class FindFloorValueInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 12, 19};
        int key = 5;

        int floorIndex = findFloorIndex(arr, key);
        int floorValue = floorIndex != -1 ? arr[floorIndex] : -1;
        System.out.println(floorValue);
    }

    private static int findFloorIndex(int[] arr, int key) {
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
        return end;
    }
}
