package DFS;
import java.util.*;

public class RestorePairs {
    public static void main(String[] args) {
        RestorePairs sol = new RestorePairs();
        int[][] pairs = {{2, 4}, {1, 4}, {1, 5}, {3, 5}};
        int[] numbers = sol.restoreArray(pairs);
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        // should print "3 5 1 4 2"
    }

    public int[] restoreArray(int[][] pairs) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] pair : pairs) {
            int a = pair[0], b = pair[1];
            if (!adjList.containsKey(a)) {
                adjList.put(a, new ArrayList<>());
            }
            adjList.get(a).add(b);
            if (!adjList.containsKey(b)) {
                adjList.put(b, new ArrayList<>());
            }
            adjList.get(b).add(a);
        }
        int index = 0, next = -1;
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer key : adjList.keySet()) {
            if (adjList.get(key).size() == 1) {
                list.add(key);
                visited.add(key);
                break;
            }
        }
        dfs(adjList.get(list.get(0)).get(0), adjList, visited, list);
        int n = adjList.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private void dfs(Integer start, Map<Integer, List<Integer>> adjList, Set<Integer> visited, List<Integer> res) {
        visited.add(start);
        res.add(start);
        List<Integer> list = adjList.get(start);
        for (Integer cur : list) {
            if (!visited.contains(cur)) {
                dfs(cur, adjList, visited, res);
            }
        }
    }
}

