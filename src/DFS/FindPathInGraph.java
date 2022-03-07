package DFS;

import java.util.ArrayList;
import java.util.List;

public class FindPathInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        // build an undirected graph
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] v : edges) {
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited, 0);
    }

    private boolean dfs(List<Integer>[] graph, int src, int dest, boolean[] visited, int index) {
        if (src == dest) {
            return true;
        }
//        if (index == graph[src].size()) {
//            return false;
//        }
        visited[src] = true;
        List<Integer> list = graph[index];
        for (Integer nei : list) {
            visited[nei] = true;
            if(dfs(graph, nei, dest, visited, index + 1)) {
                return true;
            }
            visited[nei] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        FindPathInGraph sol = new FindPathInGraph();
//        int[][] edges = {{0,1},{1,2},{2,0}};
//        System.out.println(sol.validPath(3, edges, 0, 2)); //true
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(sol.validPath(6, edges, 0, 5)); // false

    }
}
