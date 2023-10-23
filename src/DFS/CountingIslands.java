package DFS;

import java.util.*;

public class CountingIslands {
    /**
     * 题目：1代表陆地，2代表wall，0代表水
     * 每个cell 可以走8个方向(包括对角线)，从左上开始，计算每个island 能reach 的其他islands 的个数
     */
    private int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public Map<Integer, Integer> countingIslands(int[][] matrix) {
        Map<Integer, Integer> res = new HashMap<>(); // key: island sequence, value: count of neighboring isalnds
        // step 1: sequence each island
        // step 2: make wall representation to -1
        int ROWS = matrix.length, COLS = matrix[0].length;
        int seq = 1;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = -1;
                } else if (matrix[i][j] == 1 && !visited[i][j]) {
                    res.put(seq, 0); // default count of neighboring islands
                    preprocess(matrix, i, j, seq, visited);
                    seq++;
                }
            }
        }
        // step 3: start from water, count the number of islands it can reach
        boolean[][] visitedWater = new boolean[ROWS][COLS];
        List<Set<Integer>> waters2islands = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (matrix[i][j] == 0 && !visitedWater[i][j]) {
                    Set<Integer> neighbors = new HashSet<>();
                    dfs(matrix, i, j, visitedWater, neighbors);
                    waters2islands.add(neighbors);
                }
            }
        }
// helper
//        System.out.println(waters2islands);
//        for (int[] row: matrix) {
//            System.out.println(Arrays.toString(row));
//        }

        // step 4: post process to map the island to its neighboring islands
        for (Set<Integer> islands : waters2islands) {
            for (Integer island : islands) {
                res.put(island, res.getOrDefault(island, 0) + islands.size() - 1);
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited, Set<Integer> neighbors) {
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && !visited[x][y]) {
                if (matrix[x][y] == 0) {
                    dfs(matrix, x, y, visited, neighbors);
                } else if (matrix[x][y] > 0) {
                    neighbors.add(matrix[x][y]);
                }
            }
        }
    }

    private void preprocess(int[][] matrix, int x, int y, int seq, boolean[][] visited) {
        matrix[x][y] = seq;
        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == 1 && !visited[i][j]) {
                preprocess(matrix, i, j, seq, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 1, 2, 0, 1},
                {1, 2, 0, 2, 0, 1},
                {2, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}};
        CountingIslands sol = new CountingIslands();
        System.out.println(sol.countingIslands(matrix));
    }
}
