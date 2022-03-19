package DFS;

public class IslandPerimeter {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = 4 - dfs(grid, i, j);
                    res += count;
                }
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                    && grid[i][j] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        IslandPerimeter sol = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(sol.islandPerimeter(grid));
    }
}
