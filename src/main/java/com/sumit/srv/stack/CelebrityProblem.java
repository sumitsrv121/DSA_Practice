package com.sumit.srv.stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1}, {0, 0, 1}, {0, 0, 0}};

        int celebrity = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[celebrity][i] == 1) {
                celebrity = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != celebrity && (arr[celebrity][i] == 1 || arr[i][celebrity] == 0)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(celebrity);
    }
}
