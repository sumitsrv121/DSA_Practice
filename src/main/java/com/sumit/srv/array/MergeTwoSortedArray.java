package com.sumit.srv.array;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] first = {1, 2, 7, 9, 10, 12, 15};
        int[] second = {2, 4, 5, 6, 8, 11, 13, 14};

        int j = 0;
        int i = 0;
        while (i < first.length) {
            if (first[i] <= second[j]) {
                i++;
            } else {
                int temp = first[i];
                first[i] = second[j];
                second[j] = temp;
                int k = j;
                while (k < second.length - 1 && second[k] > second[k + 1]) {
                    temp = second[k];
                    second[k] = second[k + 1];
                    second[k + 1] = temp;
                    k++;
                }
            }
        }
        System.out.println(Arrays.toString(first));
        System.out.println(Arrays.toString(second));
    }
}
