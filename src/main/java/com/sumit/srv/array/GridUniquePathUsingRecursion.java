package com.sumit.srv.array;

import java.util.Arrays;

public class GridUniquePathUsingRecursion {
    private static int DEST_ROW_INDEX;
    private static int DEST_COL_INDEX;
    private static int[][] arr;

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        DEST_ROW_INDEX = m;
        DEST_COL_INDEX = n;

        arr = new int[m + 1][n + 1];

        int ways = countNumberOfUniquePaths(1, 1);
        System.out.println(ways);
        System.out.println(Arrays.deepToString(arr));
    }

    private static int countNumberOfUniquePaths(int m, int n) {
        if (m > DEST_ROW_INDEX || n > DEST_COL_INDEX) {
            return 0;
        }
        if (m == DEST_ROW_INDEX && n == DEST_COL_INDEX) {
            return 1;
        }
        if (arr[m][n] != 0) {
            System.out.println("I hit it for " + m + "," + n);
            return arr[m][n];
        }

        return arr[m][n] = countNumberOfUniquePaths(m + 1, n) + countNumberOfUniquePaths(m, n + 1);
    }
}
