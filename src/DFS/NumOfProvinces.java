package DFS;

public class NumOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int root = 0; root < n; root++) {
            if (!visited[root]) {
                dfs(isConnected, visited, root, n);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int root, int n) {
        visited[root] = true;
        for (int nei = 0; nei < n; nei++) { // traverse all the columns in row node
            if (!visited[nei] && isConnected[root][nei] == 1) {
                dfs(isConnected, visited, nei, n);
            }
        }
    }
    public static void main(String[] args) {
        int[][] input = {{1,1,0},{1,1,0},{0,0,1}};
        NumOfProvinces sol = new NumOfProvinces();
        System.out.println(sol.findCircleNum(input));
    }
}
