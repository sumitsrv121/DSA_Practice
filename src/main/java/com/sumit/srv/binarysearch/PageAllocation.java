package com.sumit.srv.binarysearch;

import java.util.Arrays;

public class PageAllocation {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        int result = MinimumMaximumPageAllocation(arr, k, max, sum);
        System.out.println(result);
    }

    private static int MinimumMaximumPageAllocation(int[] arr, int key, int start, int end) {
        int maxAllocation = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (getNumberOfStudents(arr, mid) == key) {
                maxAllocation = mid;
                end = mid - 1;
            } else if (getNumberOfStudents(arr, mid) > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return maxAllocation;
    }

    private static int getNumberOfStudents(int[] arr, int mid) {
        int count = 1;
        int sum = 0;
        for (int pages : arr) {
            if (sum + pages <= mid) {
                sum += pages;
            } else {
                count++;
                sum = pages;
            }
        }
        return count;
    }
}
