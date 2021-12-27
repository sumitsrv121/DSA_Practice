package com.sumit.srv.dynamicProgramming.matrixchainmultiplication;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int floors = 5;
        int eggs = 3;

        int min = minimumNumberOfAttempts(eggs, floors);
        System.out.println(min);
    }

    private static int minimumNumberOfAttempts(int eggs, int floors) {
        if (floors == 0 || floors == 1) {
            return floors;
        }
        if (eggs == 1) {
            return floors;
        }
        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floors; k++) {
            int temp = 1 + Math.max(minimumNumberOfAttempts(eggs - 1, k - 1),
                    minimumNumberOfAttempts(eggs, floors - k));

            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
