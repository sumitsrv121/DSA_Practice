package com.sumit.srv.binarysearch;

public class SquareRootOfGivenNumber {
    public static void main(String[] args) {
        double num = 4;

        double squareRootValue = findSquareRoot(num);
        System.out.println(squareRootValue);
    }

    private static double findSquareRoot(double num) {
        double start = 1.0;
        double end = num;
        double e = 1E-6;
        while (end - start > e) {
            double mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return mid;
            } else if (mid * mid > num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        System.out.println(start);
        System.out.println(end);
        return start;
    }
}
