package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges2 {
    //    static class Position {
//        int x;
//        int y;
//        public Position(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//    public int orangesRotting(int[][] grid) {
//        // sanity check
//        if (grid == null || grid.length == 0) {
//            return -1;
//        }
//        // BFS - enqueue
//        Queue<Position> queue = new ArrayDeque<>();
//        int time = 0; // rounds needed to rot all the oranges visited so far
//        int total = 0; // total number of oranges in the grid
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    total++;
//                } else if (grid[i][j] == 2) {
//                    total++;
//                    queue.offer(new Position(i, j));
//                }
//            }
//        }
//        if (total == 0) {
//            return 0;
//        }
//    }
    public int orangesRotting(int[][] grid) {
        if (grid == null) {
            return -1;
        }
        int freshOranges = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<Position> q = new ArrayDeque<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.offer(new Position(i, j));
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            if (freshOranges == 0) {
                return time;
            }
            time++;
            int size = q.size();
            while (size > 0) {
                Position cur = q.poll();
                for (int[] dir : dirs) {
                    int row = cur.x + dir[0];
                    int col = cur.y + dir[1];
                    if (row >= 0 && col >= 0 && row < ROWS && col < COLS && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new Position(row, col));
                        freshOranges--;
                    }
                }
                size--;
            }
        }
        return -1;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        RottenOranges2 ro = new RottenOranges2();
        int[][] array = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; // 4
        System.out.println(ro.orangesRotting(array));
        int[][] array2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(ro.orangesRotting(array2));
        int[][] array3 = {{0, 2}};
        System.out.println(ro.orangesRotting(array3));
        System.out.println(ro.orangesRotting(null));
        System.out.println(ro.orangesRotting(new int[][]{{0}})); // 0
    }
}
