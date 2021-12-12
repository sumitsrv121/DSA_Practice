package com.sumit.srv.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosetPointsToOrigin {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};

        int k = 2;
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getDistance(), e1.getDistance()));
        for (int[] ints : arr) {
            Point p = new Point(ints[0], ints[1]);
            int distance = findDistanceFromOrigin(p);
            p.setDistance(distance);
            maxHeap.add(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            Point point = maxHeap.poll();
            ans[i][0] = point.getX();
            ans[i++][1] = point.getY();
        }
        System.out.println(Arrays.deepToString(ans));
    }

    private static int findDistanceFromOrigin(Point p) {
        return (p.getX() * p.getX() + p.getY() * p.getY());
    }
}
