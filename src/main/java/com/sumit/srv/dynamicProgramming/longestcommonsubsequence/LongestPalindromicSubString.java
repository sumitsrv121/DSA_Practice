package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

public class LongestPalindromicSubString {
    private static int resultStart;
    private static int resultStartRange;

    public static void main(String[] args) {
        String x = "aaaabbaa";
        String val = findLongestPalindromeSubstring(x);
        System.out.println(val);
    }

    private static String findLongestPalindromeSubstring(String x) {
        if (x.length() < 2) {
            return x;
        }

        for (int i = 0; i < x.length(); i++) {
            expandString(x, i, i); // one length
            expandString(x, i, i + 1); // two length
        }
        return x.substring(resultStart, resultStart + resultStartRange);
    }

    private static void expandString(String x, int begin, int end) {
        while (begin >= 0 && end < x.length() && x.charAt(begin) == x.charAt(end)) {
            begin--;
            end++;
        }

        if (resultStartRange < end - begin - 1) {
            resultStartRange = end - begin - 1;
            resultStart = begin + 1;
        }
    }


}
