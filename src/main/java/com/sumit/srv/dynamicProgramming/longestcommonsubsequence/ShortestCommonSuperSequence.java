package com.sumit.srv.dynamicProgramming.longestcommonsubsequence;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";

        // LCS code start
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
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        int i = x.length();
        int j = y.length();
        StringBuilder builder = new StringBuilder();

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                builder.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] > t[i][j - 1]) {
                    builder.append(x.charAt(i - 1));
                    i--;
                } else {
                    builder.append(y.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            builder.append(x.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            builder.append(y.charAt(j - 1));
            j--;
        }

        // reverse string
        char[] ch = builder.toString().toCharArray();
        i = 0;
        j = ch.length - 1;
        while (i < j) {
            char c = ch[i];
            ch[i] = ch[j];
            ch[j] = c;
            i++;
            j--;
        }

        String lcs = new String(ch);
        System.out.println(lcs);
        // LCS code end
        
    }
}
