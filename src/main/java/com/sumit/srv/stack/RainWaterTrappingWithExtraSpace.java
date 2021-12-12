package com.sumit.srv.stack;

public class RainWaterTrappingWithExtraSpace {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] lMax = new int[arr.length];
        int[] rMax = new int[arr.length];

        int max = arr[0];
        lMax[0] = max;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            lMax[i] = max;
        }
        max = arr[arr.length - 1];
        rMax[arr.length - 1] = max;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
            }
            rMax[i] = max;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(lMax[i], rMax[i]) - arr[i];
        }
        System.out.println(sum);
    }
}
