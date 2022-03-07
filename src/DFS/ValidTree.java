package DFS;

import java.util.*;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        int count = 0;
        List<Integer>[] adjList = new ArrayList[n];
        int[] visited = new int[n];

        // build adjacency list
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        // add neighbors
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        // dfs
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(adjList, visited, i);
            }
        }

        // count visited
        for (int i = 0; i < n; i++) {
            if (visited[i] > 1 || visited[i] == 0) {
                return false;
            } else if (visited[i] == 1) {
                count++;
            }
        }
        return count == n;
    }
    private void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
        visited[startNode] += 1;
        List<Integer> list = adjList[startNode];
        for (Integer i : list) {
            if (visited[i] == 0) {
                dfs(adjList, visited, i);
            }
        }
    }
/**   4
     /
 0 - 1 - 2 - 3
      \_____/      */

    public static void main(String[] args) {
        ValidTree sol = new ValidTree();
//        int[][] input1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
//        System.out.println(sol.validTree(5, input1)); // true
        int[][] input = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(sol.validTree(5, input)); // false
    }
}
