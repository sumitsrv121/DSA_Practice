package com.sumit.srv.array;

public class SearchElementInMatrixFullySorted {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int num = 37;
        int start = 0;
        int n = arr.length;
        int m = arr[0].length;
        int end = n * m - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int i = mid / m;
            int j = mid % m;
            if (arr[i][j] == num) {
                System.out.println(i + " " + j);
                break;
            } else if (arr[i][j] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}
