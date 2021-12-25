package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";


        int len = findLongestCommonSubsequenceLength(x, y, x.length(), y.length());
        System.out.println(len);
    }

    private static int findLongestCommonSubsequenceLength(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return 1 + findLongestCommonSubsequenceLength(x, y, n - 1, m - 1);
        } else {
            return Math.max(findLongestCommonSubsequenceLength(x, y, n - 1, m),
                    findLongestCommonSubsequenceLength(x, y, n, m - 1));
        }
    }
}
