package com.sumit.srv.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int noOfOranges = 0;
        int[][] arr = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        // int[][] arr = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        //[2,1,1],[0,1,1],[1,0,1]
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new Coordinate(i, j));
                    visited[i][j] = true;
                    noOfOranges++;
                } else if (arr[i][j] == 1) {
                    noOfOranges++;
                }
            }
        }
        int noOfRows = arr.length;
        int noOfColumns = arr[0].length;

        int noOfRottenOranges = queue.size();
        int time = 0;

        while (noOfOranges - noOfRottenOranges > 0 && !queue.isEmpty()) {
            int count = queue.size();
            time++;
            while (count > 0) {
                Coordinate coordinate = queue.poll();
                int x = coordinate.getX();
                int y = coordinate.getY();
                // (x,y) -----> (x-1,y),(x+1,y),(x,y-1)(x,y+1)

                if (x - 1 >= 0 && !visited[x - 1][y] && arr[x - 1][y] == 1) {
                    queue.add(new Coordinate(x - 1, y));
                    noOfRottenOranges++;
                    visited[x - 1][y] = true;
                }

                if (x + 1 < noOfRows && !visited[x + 1][y] && arr[x + 1][y] == 1) {
                    queue.add(new Coordinate(x + 1, y));
                    noOfRottenOranges++;
                    visited[x + 1][y] = true;
                }

                if (y - 1 >= 0 && !visited[x][y - 1] && arr[x][y - 1] == 1) {
                    queue.add(new Coordinate(x, y - 1));
                    noOfRottenOranges++;
                    visited[x][y - 1] = true;
                }

                if (y + 1 < noOfColumns && !visited[x][y + 1] && arr[x][y + 1] == 1) {
                    queue.add(new Coordinate(x, y + 1));
                    noOfRottenOranges++;
                    visited[x][y + 1] = true;
                }
                count--;
            }

        }
        System.out.println(noOfOranges - noOfRottenOranges == 0 ? time : -1);
    }
}
