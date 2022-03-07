package DFS;

import java.util.Arrays;

public class ColoringBorder {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        // post-processing
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    private void dfs(int[][] grid, int row, int col, int orgColor) {
        grid[row][col] = -orgColor;
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length &&
                    grid[x][y] == orgColor) {
                // call dfs() only if (x, y) is connected compnent (the same color)
                dfs(grid, x, y, orgColor);
            }
        }
        // flip the inner connected componets to orgianl color
        if (row > 0 && row < grid.length - 1 && col > 0 && col < grid[0].length - 1) {
            if (grid[row - 1][col] == orgColor &&
                    grid[row + 1][col] == orgColor &&
                    grid[row][col - 1] == orgColor &&
                    grid[row][col + 1] == orgColor) {
                grid[row][col] = orgColor;
            }
        }
        return;
    }
    public static void main(String[] args) {
        ColoringBorder sol = new ColoringBorder();
//        int[][] grid = {{1, 1}, {1, 2}};
        int[][] grid = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};

        System.out.println(Arrays.deepToString(sol.colorBorder(grid, 0, 1, 3)));
    }
}
