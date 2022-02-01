package com.sumit.srv.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 73;
        for (int i = 0; i <= n; i++) {
            List<BigInteger> val = calculateCombination(i);
            for (BigInteger bigInteger : val) {
                System.out.print(bigInteger + " ");
            }
            System.out.println();
        }
    }

    private static List<BigInteger> calculateCombination(int n) {
        List<BigInteger> al = new ArrayList<>();
        BigInteger prevValue = BigInteger.ONE;
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                al.add(prevValue);
            } else {
                prevValue = (prevValue.multiply(BigInteger.valueOf((n - i + 1)))).divide(BigInteger.valueOf(i));
                al.add(prevValue);
            }
        }
        return al;
    }
}
