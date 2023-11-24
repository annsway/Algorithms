package DFS;

import java.util.*;

public class MakingALargeIsland {
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int seq = 1;
        Map<Integer, Integer> seq2area = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int curArea = dfs(matrix, i, j, visited, seq);
                    seq2area.put(seq, curArea);
//                    System.out.println("seq: " + seq + ", area: " + curArea);
                    seq++;
                }
            }
        }
        int globalMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> counted = new HashSet<>();
                    for (int[] dir : DIRS) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x >= 0 && x < matrix.length && y >= 0
                                && y < matrix[0].length && matrix[x][y] != 0) {
                            int k = matrix[x][y];
                            if (!counted.contains(k)) {
                                System.out.println("seq: " + k + ", area: " + seq2area.get(k));
                                counted.add(k);
                                cur += seq2area.get(k);
                            }
                        }
                    }
                    globalMax = Math.max(globalMax, cur);
                }
            }
        }
        return globalMax;
    }
    public int dfs(int[][] matrix, int i, int j, boolean[][] visited, int seq) {
        matrix[i][j] = seq;
        System.out.println(seq);
        int area = 1;
        visited[i][j] = true;
        for (int[] dir : DIRS) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && matrix[x][y] == 1 && !visited[x][y]) {
                area += dfs(matrix, x, y, visited, seq);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        MakingALargeIsland sol = new MakingALargeIsland();
        System.out.println(sol.largestIsland(new int[][]{{1, 0}, {0, 1}}));
    }
}
