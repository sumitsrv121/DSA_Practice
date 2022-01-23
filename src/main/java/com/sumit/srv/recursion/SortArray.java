package com.sumit.srv.recursion;

import java.util.ArrayList;
import java.util.List;

public class SortArray {


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.addAll(List.of(5, 7, 1, 3, 4, 2, 6));

        sort(arr);
        System.out.println(arr);
    }

    private static void sort(List<Integer> arr) {
        if (arr.size() == 1) {
            return;
        }
        int x = arr.remove(arr.size() - 1);
        sort(arr);

        insert(arr, x);

    }

    private static void insert(List<Integer> arr, int x) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) < x) {
            arr.add(x);
            return;
        }
        int lastEl = arr.remove(arr.size() - 1);
        insert(arr, x);
        arr.add(lastEl);
    }
}
