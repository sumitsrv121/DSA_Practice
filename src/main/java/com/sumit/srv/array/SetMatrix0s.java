package com.sumit.srv.array;

import java.util.Arrays;

public class SetMatrix0s {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];
        Arrays.fill(row, Integer.MIN_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
