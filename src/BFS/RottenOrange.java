package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        // count oranges
        int fresh = 0;
        Queue<Cell> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new Cell(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size > 0) {
                Cell cur = q.poll();
                int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : dirs) {
                    int x = cur.x + dir[0];
                    int y = cur.y + dir[1];
                    if (x >= 0 && x < ROWS && y >= 0 && y < COLS && !visited[x][y] && grid[x][y] == 1) {
                        visited[x][y] = true;
                        q.offer(new Cell(x, y));
                        grid[x][y] = 2;
                        fresh--;
                    }
                }
                size--;
            }
        }
        return fresh == 0 ? time : -1;
    }

    static class Cell {
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        RottenOrange ro = new RottenOrange();
        int[][] array = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; // 4
        System.out.println(ro.orangesRotting(array));
//        int[][] array2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        System.out.println(ro.orangesRotting(array2));
//        int[][] array3 = {{0, 2}};
//        System.out.println(ro.orangesRotting(array3));
//        System.out.println(ro.orangesRotting(null));
//        System.out.println(ro.orangesRotting(new int[][]{{0}})); // 0
    }
}
