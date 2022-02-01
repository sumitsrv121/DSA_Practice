package com.sumit.srv.string;

public class RotatedString {
    public static void main(String[] args) {
        String str = "sumit";
        String str1 = "tsuim";
        if (str.length() != str1.length()) {
            System.out.println(false);
            return;
        }
        String s = str + str;
        System.out.println(s.contains(str1));
    }
}
