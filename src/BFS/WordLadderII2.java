package BFS;

import java.util.*;
/**
 * https://learning.laioffer.com/app/discussion/809
 * 我想請問時間和空間複雜度，想問分析的對不對
 * TC: total O(26*wordLen*n + (26*wordLen)^n)
 *        1. BFS: wordlist有n個word， graph最多會有n個word，每個word要檢查26*wordLen，所以需
 *            要O(26*wordLen*n)
 *        2. DFS: 每個word最多可以有26*wordLen個branch，最多n層，所以總共O((26*wordLen)^n)
 * SC: total O(n^2)
 *        1. BFS:每個word都有neighbors list，所以有O(n*n-1)
 *        2. DFS:直上直下最多就是O(n)，存path最多空間O(26*wordLen) 假如beginWord的每種可能都
 * */
public class WordLadderII2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>(wordList);
        set.add(beginWord);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        for (String str : set) {
            nodeNeighbors.put(str, new ArrayList<>());
        }
        // map 用来记录每个 word 走到 endWord 的距离 (?)
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();
        solution.add(beginWord);
        set.add(beginWord);
        bfs(beginWord, endWord, set, nodeNeighbors, map);
        dfs(beginWord, endWord, nodeNeighbors, map, solution, res);
        return res;
    }

    private void bfs(String beginWord, String endWord, Set<String> set, HashMap<String
            , ArrayList<String>> nodeNeighbors, Map<String, Integer> map) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        map.put(beginWord, 0); // map to record the # of steps needed from beginWord to
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int step = map.get(curr);
                // Q: How to find cur's neighbors (change only one char of cur && is in the set)
                List<String> neighbors = findNeighbor(curr, set);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(curr).add(neighbor); // add curr's neighbor to curr's list
                    // mark neighbor as visited (否则走重复的路径)
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, step + 1); // 路径 +1
                        if (neighbor.equals(endWord)) {
                            break;
                        }
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    private void dfs(String curr, String endWord, HashMap<String, ArrayList<String>> nodeNeighbors
            , Map<String, Integer> map, ArrayList<String> solution, List<List<String>> res) {
        if (endWord.equals(curr)) {
            res.add(new ArrayList<>(solution));
            return;
        }
        for (String next : nodeNeighbors.get(curr)) {
            if (map.get(next) == map.get(curr) + 1) {
                solution.add(next);
                dfs(next, endWord, nodeNeighbors, map, solution, res);
                solution.remove(solution.size() - 1);
            }
        }
    }

    private List<String> findNeighbor(String currWord, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] currArray = currWord.toCharArray();
        for (int i = 0; i < currArray.length; i++) {
            char orig = currArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == orig) {
                    continue;
                }
                currArray[i] = j;
                String newWord = String.valueOf(currArray);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            currArray[i] = orig;
        }
        return neighbors;
    }
    public static void main(String[] args) {
        WordLadderII2 sol = new WordLadderII2();
        String[] s = {"git", "hit", "hog", "hot", "got"};
        List<String> list = new ArrayList<>(Arrays.asList(s));
        System.out.println(sol.findLadders("git", "hot", list));
    }
}
