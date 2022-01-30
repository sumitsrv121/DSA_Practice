package com.sumit.srv.array;

import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        // int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = {{1, 4}, {1, 5}};
        Set<Pair> intervalSet = new TreeSet<>((p1, p2) -> p1.start > p2.start ? 1 : (p1.start < p2.start ? -1 : Integer.compare(p1.end, p2.end)));
        for (int[] ints : arr) {
            intervalSet.add(new Pair(ints[0], ints[1]));
        }
        System.out.println(intervalSet);
        Iterator<Pair> itr = intervalSet.iterator();
        Pair pair = itr.next();
        int start = pair.start;
        int end = pair.end;
        List<Pair> al = new ArrayList<>();
        while (itr.hasNext()) {
            pair = itr.next();
            if (end >= pair.start) {
                end = Math.max(end, pair.end);
            } else {
                al.add(new Pair(start, end));
                start = pair.start;
                end = pair.end;
            }
        }
        al.add(new Pair(start, end));

        System.out.println(al);
    }

    static class Pair {
        public int start;
        public int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
