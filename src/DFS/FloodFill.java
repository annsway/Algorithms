package DFS;

import java.util.Arrays;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] visited = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (i == sr && j == sc) {
                    dfs(image, visited, sr, sc, image[sr][sc], newColor, dirs);
                    return image;
                } else {
                    visited[i][j] = -1;
                }
            }
        }
        return image;
    }
    private void dfs(int[][] image, int[][] visited, int sr, int sc, int oldColor, int newColor, int[][] dirs) {
        image[sr][sc] = newColor;
//        visited[][]
        for (int[] dir : dirs) {
            int x = sr + dir[0];
            int y = sc + dir[1];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length
                    && image[x][y] == oldColor) {
//                dfs(image, x, y, oldColor, newColor, dirs);
            }
        }
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();
        System.out.println(Arrays.deepToString(sol.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)));
    }
}
