package com.sumit.srv.array;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[4][10];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        System.out.println(arr.length + "*" + arr[0].length);
        printSpiralMatrix(arr, arr.length, arr[0].length);
    }

    private static void printSpiralMatrix(int[][] arr, int n, int m) {
        int top = 0;
        int down = n - 1;
        int left = 0;
        int right = m - 1;
        int dir = 0;

        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(arr[top][i] + "\t");
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    System.out.print(arr[i][right] + "\t");
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[down][i] + "\t");
                }
                down--;
            } else if (dir == 3) {
                for (int i = down; i >= top; i--) {
                    System.out.print(arr[i][left] + "\t");
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }
    }
}
