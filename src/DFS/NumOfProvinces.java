package DFS;

public class NumOfProvinces {
    public int findCircleNum(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        int count = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!visited[i]) {
                // Do dfs() on un-visited nodes
                dfs(adjMatrix, visited, i);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            // M[i][j] = 1: stands for the neighbor [j] and node [i] are connected
            // M[i][j] = 0: stands for the neighbor [j] and node [i] are NOT connected
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
    public static void main(String[] args) {
        int[][] input = {{1,1,0},{0,1,0},{1,0,1}};
        NumOfProvinces sol = new NumOfProvinces();
        System.out.println(sol.findCircleNum(input));
    }
}
