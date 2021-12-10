package com.sumit.srv.binarysearch;

public class SearchElementIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int key = 39;
        String index = binarySearch(arr, key);
        System.out.println(index);
    }

    private static String binarySearch(int[][] arr, int key) {
        int i = 0;
        int j = arr[0].length - 1;
        while (i >= 0 && i <= arr[0].length - 1 && j >= 0 && j <= arr[0].length - 1) {
            if (arr[i][j] == key) {
                return i + "----->" + j;
            } else if (arr[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }
        return String.valueOf(-1);
    }
}
