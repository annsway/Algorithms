package DFS;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int sum = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < ROWS && y >= 0 && y < COLS) {
                            count += grid[x][y];
                        }
                    }
                    count = 4 - count;
                    sum += count;
                }
            }
        }
        return sum;
    }

}
