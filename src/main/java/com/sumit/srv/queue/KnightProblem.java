package com.sumit.srv.queue;

import java.util.LinkedList;
import java.util.Queue;

public class KnightProblem {
    public static void main(String[] args) {
        int n = 6;
        boolean[][] arr = new boolean[n][n];
        int[] knightPosition = {3, 4};
        int[] targetPosition = {0, 0};


        Queue<Coordinate> queue = new LinkedList<>();

        // update the position of knight as visited
        arr[knightPosition[0]][knightPosition[1]] = true;
        queue.offer(new Coordinate(knightPosition[0], knightPosition[1]));

        int totalNoOfPosition = n * n;
        int visitedNoOfPosition = 1;
        int moves = 0;
        while (!queue.isEmpty() &&
                totalNoOfPosition - visitedNoOfPosition > 0) {
            boolean isPositionFound = false;
            int count = queue.size();
            while (count > 0) {
                Coordinate coordinate = queue.poll();
                int x = coordinate.getX();
                int y = coordinate.getY();
                if (x == targetPosition[0] && y == targetPosition[1]) {
                    isPositionFound = true;
                    break;
                }

                // (x,y) ---> (x-1, y+2) (x+1, y+2) (x-1, y-2) (x+1, y-2)
                if (x - 1 >= 0 && y + 2 < n && !arr[x - 1][y + 2]) {
                    arr[x - 1][y + 2] = true;
                    queue.offer(new Coordinate(x - 1, y + 2));
                    visitedNoOfPosition++;
                }

                if (x + 1 < n && y + 2 < n && !arr[x + 1][y + 2]) {
                    arr[x + 1][y + 2] = true;
                    queue.offer(new Coordinate(x + 1, y + 2));
                    visitedNoOfPosition++;
                }

                if (x - 1 >= 0 && y - 2 >= 0 && !arr[x - 1][y - 2]) {
                    arr[x - 1][y - 2] = true;
                    queue.offer(new Coordinate(x - 1, y - 2));
                    visitedNoOfPosition++;
                }

                if (x + 1 < n && y - 2 >= 0 && !arr[x + 1][y - 2]) {
                    arr[x + 1][y - 2] = true;
                    queue.offer(new Coordinate(x + 1, y - 2));
                    visitedNoOfPosition++;
                }
                // (x-2,y+1) (x+2, y+1) (x-2, y-1) (x+2, y-1)

                if (x - 2 >= 0 && y + 1 < n && !arr[x - 2][y + 1]) {
                    arr[x - 2][y + 1] = true;
                    queue.offer(new Coordinate(x - 2, y + 1));
                    visitedNoOfPosition++;
                }

                if (x + 2 < n && y + 1 < n && !arr[x + 2][y + 1]) {
                    arr[x + 2][y + 1] = true;
                    queue.offer(new Coordinate(x + 2, y + 1));
                    visitedNoOfPosition++;
                }

                if (x - 2 >= 0 && y - 1 >= 0 && !arr[x - 2][y - 1]) {
                    arr[x - 2][y - 1] = true;
                    queue.offer(new Coordinate(x - 2, y - 1));
                    visitedNoOfPosition++;
                }

                if (x + 2 < n && y - 1 >= 0 && !arr[x + 2][y - 1]) {
                    arr[x + 2][y - 1] = true;
                    queue.offer(new Coordinate(x + 2, y - 1));
                    visitedNoOfPosition++;
                }
                count--;
            }
            if (isPositionFound) {
                break;
            }
            moves++;
        }

        System.out.println(moves);
    }
}
