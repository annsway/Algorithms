package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcToDest {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // build graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<Integer>[] graph, int src, int dest, boolean[] visited) {
        if (graph[src].isEmpty()) { // meaning the last node
            return src == dest;
        }
        if (visited[src]) {
            return false;
        }
        visited[src] = true;
        for (int nei : graph[src]) {
            if (!dfs(graph, nei, dest, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
        AllPathsFromSrcToDest sol = new AllPathsFromSrcToDest();
//        System.out.println(sol.leadsToDestination(4, edges, 0, 3)); // expected: true

        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(sol.leadsToDestination(3, edges, 0, 2)); // expected: false

    }
}
