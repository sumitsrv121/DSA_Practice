package com.sumit.srv.array;

import java.util.Arrays;

public class CountInversions {
    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println("Count " + count);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int[] left = new int[n1];
        int n2 = end - mid;
        int[] right = new int[n2];
        int k = start;
        for (int i = 0; i < n1; i++) {
            left[i] = arr[k++];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[k++];
        }

        // merge
        k = start;
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                count = count + n1 - i;
                int a = i;
                while (a < n1) {
                    System.out.println("(" + left[a++] + "," + right[j] + ")");
                }
                arr[k++] = right[j++];
            }
        }

        if (i >= left.length) {
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        } else {
            while (i < left.length) {
                arr[k++] = left[i++];
            }
        }
    }
}
