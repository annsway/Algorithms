package DFS;

/**
 *  maze:输入一个2D array, m*n(0代表墙，1代表路)，一只老鼠站在(0， 0)处，
 *  在迷宫的某处有cheese的(标记为9)，问是否存在路径通向吃的。return的1为能达到，0为不能。
 *  */
public class MazeAndCheese {
    public boolean findPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        return dfs(matrix, 0, 0, visited, dirs);
    }

    private boolean dfs(int[][] matrix, int i, int j, boolean[][] visited, int[][] dirs) {
        if (matrix[i][j] == 9) {
            return true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                    && !visited[x][y] && matrix[x][y] != 0) {
                if (dfs(matrix, x, y, visited, dirs)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 1, 0, 1},
//                {1, 1, 1, 0},
//                {0, 0, 1, 0},
//                {9, 0, 1, 0}};
        int[][] matrix = {
                {0}};
        MazeAndCheese sol = new MazeAndCheese();
        System.out.println(sol.findPath(matrix));
    }
}
