package com.sumit.srv.array;

public class ExponentialPower {
    public static void main(String[] args) {
        double x = 2;
        int y = -10;
        long pow = y < 0 ? -1 * y : y;
        double v = calculatePower(x, pow);
        v = (y < 0) ? 1.0 / v : v;
        System.out.println(v);
    }

    private static double calculatePower(double x, long y) {
        if (y == 0) {
            return 1.0;
        }
        if (y % 2 == 0) {
            return calculatePower(x * x, y / 2);
        } else {
            return x * calculatePower(x, y - 1);
        }
    }
}
