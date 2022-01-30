package com.sumit.srv.array;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 1, 2, 1};

        int sum = 0;
        int squareSum = 0;

        int n = arr.length;
        for (int j : arr) {
            sum += j;
            squareSum += j * j;
        }

        int naturalNumberSum = (n * (n + 1)) / 2;
        int naturalNumberSquareSum = (n * (n + 1) * (2 * n + 1)) / 6;

        int diff = naturalNumberSum - sum; // x-y
        int squareDiff = naturalNumberSquareSum - squareSum; //x2 - y2

        int sumDiff = squareDiff / diff;

        int x = (sumDiff + diff) / 2;
        int y = x - diff;

        System.out.println(x + " " + y);
    }
}
