package com.sumit.srv.binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public static StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        int[] stalls = {4, 2, 1, 3, 6};
        int k = 2;
        Arrays.sort(stalls);
        System.out.println(Arrays.toString(stalls));
        int min = stalls[0];
        int max = stalls[stalls.length - 1];
        int distance = findAllocation(stalls, k, min, max);
        System.out.println(distance);
        buildPath(stalls, distance);
        System.out.println(path);
    }

    private static int findAllocation(int[] stalls, int k, int start, int end) {
        int distance = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int numberOfCows = getNumberOfCows(stalls, mid - stalls[0], k);
            if (numberOfCows == k) {
                distance = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return distance - stalls[0];
    }

    private static int getNumberOfCows(int[] arr, int mid, int k) {
        int p = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[p] >= mid) {
                count++;
                p = i;
            }
            if (k == count) {
                break;
            }
        }
        return count;
    }

    private static void buildPath(int[] arr, int mid) {
        int p = 0;
        int position = arr[0];
        path.append(position).append("-");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[p] >= mid) {
                path.append(arr[i]).append("-");
                p = i;
            }
        }
    }

}
