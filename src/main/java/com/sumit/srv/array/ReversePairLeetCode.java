package com.sumit.srv.array;

import java.util.Arrays;

public class ReversePairLeetCode {
    private static int count;

    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};
        //int[] arr = {};
        count = 0;
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(count);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (end - start) / 2 + start;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        int k = start;
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[k++];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[k++];
        }

        int l = 0;
        for (int i = 0; i < left.length; i++) {
            while (l < right.length && 2L * right[l] < left[i]) {
                l++;
            }
            count += l;
        }

        int i = 0;
        int j = 0;
        k = start;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }
    }
}
