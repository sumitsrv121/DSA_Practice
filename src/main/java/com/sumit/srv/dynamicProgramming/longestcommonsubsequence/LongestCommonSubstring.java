package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "zxabcdezy";
        String y = "yzabcdezx";

        int result = Integer.MIN_VALUE;

        int[][] t = new int[x.length() + 1][y.length() + 1];


        for (int i = 0; i < t.length; i++) {
            t[i][0] = 0;
        }

        for (int i = 1; i < t[0].length; i++) {
            t[0][i] = 0;
        }

        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    if (t[i][j] > result) {
                        result = t[i][j];
                    }
                } else {
                    t[i][j] = 0;
                }
            }
        }

        System.out.println(result);
    }
}
