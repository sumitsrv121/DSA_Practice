package com.sumit.srv.array;

import java.util.Arrays;

public class ReverseImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // find transpose
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        // every row reverse element
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = arr[i].length - 1;
            while (start < end) {
                int temp = arr[i][start];
                arr[i][start++] = arr[i][end];
                arr[i][end--] = temp;
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
