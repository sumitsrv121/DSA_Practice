package com.sumit.srv.binarysearch;

public class NextAlphabet {
    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'f', 'f', 'f', 'h'};
        char key = 'g';

        int index = findNextAlphabet(arr, key);
        char ans = index < arr.length ? arr[index] : '-';
        System.out.println(ans);
    }

    private static int findNextAlphabet(char[] arr, char key) {
        int start = 0;
        int end = arr.length - 1;
        int lastIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                lastIndex = mid;
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lastIndex != -1 ? lastIndex + 1 : start;
    }
}
