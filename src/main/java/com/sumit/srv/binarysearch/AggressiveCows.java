package com.sumit.srv.binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public static String path = "";

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 5};
        int k = 3;
        Arrays.sort(stalls);
        System.out.println(Arrays.toString(stalls));
        int min = stalls[0];
        int max = stalls[stalls.length - 1];
        int distance = findAllocation(stalls, k, min, max);
        path = buildPath(stalls, distance);
        System.out.println(path);
    }

    private static int findAllocation(int[] stalls, int k, int start, int end) {
        int distance = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int numberOfCows = getNumberOfCows(stalls, mid);
            if (numberOfCows >= k) {
                distance = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(distance);
        return distance;
    }

    private static int getNumberOfCows(int[] stalls, int mid) {
        int count = 1;
        int position = stalls[0];
        while ((position = findCeil(stalls, position + mid)) != -1) {
            count++;
        }
        return count;
    }

    private static String buildPath(int[] arr, int mid) {
        int position = arr[0];
        path += position + "-";
        while ((position = findCeil(arr, position + mid)) != -1) {
            path += position + "-";
        }
        return path;
    }

    private static int findCeil(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start >= arr.length ? -1 : arr[start];
    }
}
