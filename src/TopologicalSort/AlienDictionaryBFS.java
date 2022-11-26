package TopologicalSort;

import java.util.*;

public class AlienDictionaryBFS {
    public static String alienOrder(String[] words) {
        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];
            if (s1.length() > s2.length() && s2.equals(s1.substring(0, s2.length()))) {
                return "";
            }
        }
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> adjList = new HashMap<>(); // key: char, value: following neighbors
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                indegree.put(w.charAt(i), 0); // put every unique char into the indegree
                // System.out.println(w.charAt(i));
            }
        }

        // build adjList:
        boolean flag = false;
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int j = 0;
            while (j < cur.length() && j < next.length()) {
                char a = cur.charAt(j), b = next.charAt(j);
                if (a != b) {
                    Set<Character> set = adjList.getOrDefault(a, new HashSet<>());
                    if (!set.contains(b)) {
                        set.add(b);
                        adjList.put(a, set);
                        indegree.put(b, indegree.get(b) + 1);
                    }
                    flag = true;
                    break;
                }
                j++;
            }
            if (!flag) {

            }
        }
        // topological sort
        Queue<Character> q = new ArrayDeque<>();
        for (Character key : indegree.keySet()) {
            // System.out.println(key);
            if (indegree.get(key) == 0) {
                q.offer(key);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            res.append(cur);
            Set<Character> neighbors = adjList.get(cur);
            // System.out.println("cur " + cur + " neighbors: " + neighbors);
            if (neighbors != null) { // last level does not have any children
                for (Character nei : neighbors) {
                    indegree.put(nei, indegree.get(nei) - 1);
                    if (indegree.get(nei) == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        System.out.println(indegree);
        System.out.println(res);
        if (res.length() != indegree.size()) {
            return "";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(AlienDictionaryBFS.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"})); // "wertf"
        System.out.println(AlienDictionaryBFS.alienOrder(new String[]{"ac","ab","zc","zb"})); // "acbz"
        System.out.println(AlienDictionaryBFS.alienOrder(new String[]{"abc", "ab"})); // ""

    }
}
