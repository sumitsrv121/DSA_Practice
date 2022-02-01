package com.sumit.srv.array;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 4, 2, 4, 3, 4, 6, 4, 4, 4, 7, 4, 1};

        int count = 0;
        int el = 0;
        for (int j : arr) {
            if (count == 0) {
                el = j;
            }

            if (el == j) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        System.out.println(el);
    }
}
