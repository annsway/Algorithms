package OOD;

import java.util.Arrays;

public class Minesweeper {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    int[][] solution(boolean[][] field, int x, int y) {
        int m = field.length, n = field[0].length;
        int[][] middle = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbors(field, i, j);
                middle[i][j] = count;
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        dfs(middle, x, y, res);
        return res;
    }

    void dfs(int[][] middle, int i, int j, int[][] res) {
        if (middle[i][j] > 0) {
            res[i][j] = middle[i][j]; // number
            return;
        }
        if (middle[i][j] == 0 && res[i][j] == -1) {
            res[i][j] = middle[i][j]; // 0
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < res.length && y >= 0 && y < res[0].length) {
                    dfs(middle, x, y, res);
                }
            }

        }
    }

    int countNeighbors(boolean[][] field, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < field.length && y >= 0 && y < field[0].length
                    && field[x][y]) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        boolean[][] field = {
                {true, false, true, true, false},
                {true, false, false, false, false},
                {false, false, false, false, false},
                {true, false, false, false, false}};
        Minesweeper sol = new Minesweeper();
        System.out.println(Arrays.deepToString(sol.solution(field, 3, 2)));
        /**
         [[-1, -1, -1, -1, -1],
          [-1,  3,  2,  2,  1],
          [-1,  2,  0,  0,  0],
          [-1,  1,  0,  0,  0]]
         */
    }

}
