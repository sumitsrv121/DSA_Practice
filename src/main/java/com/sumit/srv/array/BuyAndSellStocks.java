package com.sumit.srv.array;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int stockPrice : arr) {
            if (min > stockPrice) {
                min = stockPrice;
            }
            maxProfit = Math.max(maxProfit, stockPrice - min);
        }
        System.out.println(maxProfit);
    }
}
