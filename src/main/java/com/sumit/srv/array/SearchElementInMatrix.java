package com.sumit.srv.array;

public class SearchElementInMatrix {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        int i = 0;
        int j = arr[0].length - 1;
        int n = 33;
        boolean isFound = false;
        while (i >= 0 && i < arr.length && j >= 0 && j < arr[i].length) {
            if (arr[i][j] == n) {
                isFound = true;
                break;
            } else if (arr[i][j] > n) {
                j--;
            } else {
                i++;
            }
        }
        if (isFound)
            System.out.println(i + " " + j);
        else
            System.out.println("Not found");
    }
}
