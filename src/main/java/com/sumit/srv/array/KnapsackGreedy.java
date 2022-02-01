package com.sumit.srv.array;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class KnapsackGreedy {
    public static void main(String[] args) {
        int[] wt = {10, 20, 30, 12};
        int[] val = {60, 100, 120, 72};
        int bagWeight = 50;

        Set<Pair> set = new TreeSet<>((p1, p2) -> p1.val < p2.val ? 1 : (p1.val > p2.val) ? -1 : Integer.compare(p1.index, p2.index));

        for (int i = 0; i < wt.length; i++) {
            set.add(new Pair((double) (val[i] / wt[i]), i));
        }

        System.out.println(set);

        int currWt = 0;
        double currVal = 0;
        Iterator<Pair> itr = set.iterator();
        int i = 0;
        boolean isFrac = false;
        while (itr.hasNext()) {
            Pair pair = itr.next();
            i = pair.index;
            if (wt[i] + currWt <= bagWeight) {
                currVal += val[i];
                currWt += wt[i];
            } else {
                isFrac = true;
                break;
            }
        }
        if (isFrac) {
            int leftWt = bagWeight - currWt;
            double cost = leftWt * (double) (val[i] / wt[i]);
            currVal += cost;
        }

        System.out.println(currVal);
    }

    static class Pair {
        Double val;
        Integer index;

        public Pair(Double val, Integer index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "val=" + val +
                    ", index=" + index +
                    '}';
        }
    }
}
