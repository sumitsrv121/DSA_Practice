package com.sumit.srv.array;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] num = {1, 3, 5, 4, 2};
        // int[] num = {5, 4, 3, 2, 1};
        /*   5
         * 3   4
         *1      2
         * */

        // find the steep to peak index from end
        int pIndex = num.length - 2;
        while (pIndex >= 0 && num[pIndex] >= num[pIndex + 1]) {
            pIndex--;
        }

        // find number from end which is greater than num[pIndex]
        int gIndex = -1;
        for (int i = num.length - 1; i >= 0 && pIndex >= 0; i--) {
            if (num[pIndex] < num[i]) {
                gIndex = i;
                break;
            }
        }
        int temp;
        // swap val from both index
        if (gIndex >= 0) {
            temp = num[pIndex];
            num[pIndex] = num[gIndex];
            num[gIndex] = temp;
        }


        // reverse element from pIndex+1 to end
        int start = pIndex + 1;
        int end = num.length - 1;
        while (start < end) {
            temp = num[end];
            num[end] = num[start];
            num[start] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(num));
    }
}
