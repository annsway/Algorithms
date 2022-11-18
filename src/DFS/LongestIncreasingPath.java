package DFS;

public class LongestIncreasingPath {
    int[][] dirs = {{-1, 0},{1, 0},{0,-1},{0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n]; // dp[i][j] represents the longest increasing path starting from cell [i, j]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = dfs(matrix, i, j, dp);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j]; // means [i, j] has been visited and recorded
        }
        dp[i][j] = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
                    matrix[x][y] > matrix[i][j]) {
//                System.out.println("i: " + i + " j: " + j + " x:" + x + " y:" + y);
                int count = dfs(matrix, x, y, dp) + 1;
                dp[i][j] = Math.max(dp[i][j], count);
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}}; // 4
//        int[][] matrix = {
//                {7,8,9},
//                {9,7,6},
//                {7,2,3}}; // 6
        LongestIncreasingPath sol = new LongestIncreasingPath();
        System.out.println(sol.longestIncreasingPath(matrix));
    }
}
