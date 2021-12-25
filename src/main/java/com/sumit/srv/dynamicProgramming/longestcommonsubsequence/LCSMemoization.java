package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

import java.util.Arrays;

public class LCSMemoization {
    private static int[][] t;

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";

        t = new int[x.length() + 1][y.length() + 1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }
        int len = findLCSLength(x, y, x.length(), y.length());
        System.out.println(len);
        System.out.println(Arrays.deepToString(t));
    }

    private static int findLCSLength(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return t[n][m] = 0;
        }
        if (t[n][m] != -1) {
            return t[n][m];
        }
        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return t[n][m] = 1 + findLCSLength(x, y, n - 1, m - 1);
        } else {
            return t[n][m] = Math.max(findLCSLength(x, y, n - 1, m), findLCSLength(x, y, n, m - 1));
        }
    }
}
