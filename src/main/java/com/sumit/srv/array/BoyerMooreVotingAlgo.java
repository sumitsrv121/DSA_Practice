package com.sumit.srv.array;

public class BoyerMooreVotingAlgo {
    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 3, 1, 4, 5, 6};

        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for (int el : nums) {
            if (candidate1 == el) {
                count1++;
            } else if (candidate2 == el) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = el;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = el;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int el : nums) {
            if (el == candidate1) {
                count1++;
            } else if (el == candidate2) {
                count2++;
            }
        }

        if (count1 > Math.floor(nums.length / 3.0)) {
            System.out.println(candidate1);
        }

        if (count2 > Math.floor(nums.length / 3.0)) {
            System.out.println(candidate2);
        }
    }
}
