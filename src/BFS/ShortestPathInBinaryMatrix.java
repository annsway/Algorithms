package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        if (grid.length == 1 && grid[0][0] == 0) {
            return 1;
        }
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1},{-1, -1},{-1, 1},{1, -1},{1, 1}};
        List<List<Cell>> res = new ArrayList<>();
        Queue<List<Cell>> q = new ArrayDeque<>(); // record paths

        List<Cell> start = new ArrayList<>();
        start.add(new Cell(0, 0));
        q.offer(start);

        while (!q.isEmpty()) {
            List<Cell> path = q.poll();
            Cell node = path.get(path.size() - 1);
            visited[node.x][node.y] = true;
            for (int[] dir : dirs) {
                int x = node.x + dir[0];
                int y = node.y + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < n
                        && !visited[x][y] && grid[x][y] == 0) {
                    List<Cell> pathAdded = new ArrayList<>(path);
                    pathAdded.add(new Cell(x, y));
                    if (x == n - 1 && y == n - 1) {
                        res.add(pathAdded);
                    } else {
                        q.offer(pathAdded);
                    }
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (List<Cell> path : res) {
            shortest = Math.min(shortest, path.size());
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
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
        ShortestPathInBinaryMatrix sol = new ShortestPathInBinaryMatrix();
//        int[][] grid = {{0,1},{1,0}};// 2
        int[][] grid = {{0}}; // 1
        System.out.println(sol.shortestPathBinaryMatrix(grid));
    }
}
