package TopologicalSort;

import java.util.*;

public class AlienDictionaryDFS {
    public String alienOrder(String[] words) {
        // build adj list
        Map<Character, Set<Character>> adjList = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adjList.put(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int k = 0;
            // edge case: input is not in lexicographic order
            if (cur.length() > next.length() && next.equals(cur.substring(0, next.length()))) {
                return "";
            }
            while (k < cur.length() && k < next.length()) {
                char c1 = cur.charAt(k);
                char c2 = next.charAt(k);
                if (c1 != c2) {
                    Set<Character> set = adjList.get(c1);
                    set.add(c2);
                    adjList.put(c1, set);
                    break;
                }
                k++;
            }
        }
        // DFS
        Map<Character, Boolean> visited = new HashMap<>(); // {key: char, value: visited_on_cur_path}
        StringBuilder sb = new StringBuilder();
        for (Character key : adjList.keySet()) {
            if (dfs(key, adjList, visited, sb)) { // True: detected cycle
                return "";
            }
        }
        sb.reverse();
        return sb.toString();
    }

    private boolean dfs(Character key, Map<Character, Set<Character>> adjList,
                        Map<Character, Boolean> visited, StringBuilder sb) {
        if (visited.containsKey(key)) {
            return visited.get(key);
        }
        visited.put(key, true);
        Set<Character> neighbors = adjList.get(key);
        if (neighbors != null) {
            for (Character nei : neighbors) {
                if (dfs(nei, adjList, visited, sb)) { // True: detected cycle
                    return true;
                }
            }
        }
        sb.append(key);
        visited.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        AlienDictionaryDFS sol = new AlienDictionaryDFS();
        System.out.println(sol.alienOrder(words)); // "wertf"
    }
}
