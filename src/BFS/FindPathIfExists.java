package BFS;

import java.util.*;

public class FindPathIfExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Set<Integer> seen = new HashSet<>();
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (!graph.containsKey(n1)) {
                graph.put(n1, new ArrayList<>());
            }
            graph.get(n1).add(n2);
            if (!graph.containsKey(n2)) {
                graph.put(n2, new ArrayList<>());
            }
            graph.get(n2).add(n1);
        }
        // bfs
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        while (!q.isEmpty()) {
            int cur = q.poll();
            seen.add(cur);
            if (cur == destination) {
                return true;
            }
            for (Integer nei : graph.get(cur)) {
                if (!seen.contains(nei)) {
                    q.offer(nei);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindPathIfExists sol = new FindPathIfExists();
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(sol.validPath(6, edges, 0, 5));
    }
}
