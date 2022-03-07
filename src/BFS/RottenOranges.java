package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class RottenOranges {
    // Why? Level order traversal
    // store the position of rotten orange
    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        // sanity check
        if (grid == null || grid.length == 0) {
            return -1;
        }

        Queue<Position> queue = new ArrayDeque<>();
        int total = 0, rotten = 0, time = 0;

        // traverse the grid, offer position of rotten orange into queue, and count the total num of orange
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new Position(i, j));
                }
            }
        }

        // if there is no orange, return 0;
        if (total == 0) return 0;

        while (!queue.isEmpty()) {
            // size is the num of rotten oranges of the last round
            int size = queue.size();

            // count the num of rotten oranges, if it equals to total num, return time;
            rotten += size;
            if (rotten == total) {
                return time;
            }

            // every round, time ++
            time++;

            // Continue to dequeue until all rotten oranges of last round are removed from the queue
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();

                // check the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, enqueue it.
                // left
                if (position.y - 1 >= 0 && grid[position.x][position.y - 1] == 1) {
                    grid[position.x][position.y - 1] = 2;
                    queue.offer(new Position(position.x, position.y - 1));
                }
                // right
                if (position.y + 1 < grid[0].length && grid[position.x][position.y + 1] == 1) {
                    grid[position.x][position.y + 1] = 2;
                    queue.offer(new Position(position.x, position.y + 1));
                }
                // top
                if (position.x - 1 >= 0 && grid[position.x - 1][position.y] == 1) {
                    grid[position.x - 1][position.y] = 2;
                    queue.offer(new Position(position.x - 1, position.y));
                }
                // bottom
                if (position.x + 1 < grid.length && grid[position.x + 1][position.y] == 1) {
                    grid[position.x + 1][position.y] = 2;
                    queue.offer(new Position(position.x + 1, position.y));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] array = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(array));
        int[][] array2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(array2));
        int[][] array3 = {{0, 2}};
        System.out.println(orangesRotting(array3));
        System.out.println(orangesRotting(null));
    }

}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Coord> queue = new ArrayDeque<>();
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Coord(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int time = -1;
        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coord pos = queue.poll();
                for (int[] dir : directions) {
                    if (pos.x + dir[0] < m && pos.x + dir[0] >= 0 &&
                            pos.y + dir[1] < n && pos.y + dir[1] >= 0 &&
                            grid[pos.x + dir[0]][pos.y + dir[1]] == 1) {
                        grid[pos.x + dir[0]][pos.y + dir[1]] = 2;
                        queue.offer(new Coord(pos.x + dir[0], pos.y + dir[1]));
                        fresh--;
                    }
                }
            }
            time++;
        }
        if (fresh == 0) {
            return time;
        } else {
            return -1;
        }
    }
}

class Coord {
    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
