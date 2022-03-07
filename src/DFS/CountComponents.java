package DFS;

import java.util.ArrayList;
import java.util.List;

public class CountComponents {
    /**
     * Q: Why do we traverse nodes rather than edges?
     * A: Assume input has 5 nodes without any edges. If you only traverse the edges, then you'll get 0 in the result (actual: 5).
     */
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]); // 因为是 Undirected graph, 所以邻居也必须反指node
        }
        for (int i = 0; i < n; i++) { // node i
            if (!visited[i]) {
                dfs(adjList, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(List<Integer>[] adjList, boolean[] visited, int i) {
        visited[i] = true;
        // color the neighbors of node i, adjList[i].get(j) is the jth neighbor of node i
        for (int j = 0; j < adjList[i].size(); j++) {
            int nei_j = adjList[i].get(j);
            if (!visited[nei_j]) {
                dfs(adjList, visited, nei_j);
            }
        }
    }

    public static void main(String[] args) {
        CountComponents sol = new CountComponents();
        int[][] input = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(sol.countComponents(5, input));
    }
}