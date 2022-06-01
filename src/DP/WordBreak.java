package DP;

import java.util.*;

public class WordBreak {
    private Map<String, Boolean> mem = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // recursion
        return wordBreak(s, dict);
    }
    public boolean wordBreak(String s, Set<String> dict) {
        // base case 1
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        // base case 2: if the entire string s is a word
        if (dict.contains(s)) {
            mem.put(s, true);
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            // find solution for s
            if (dict.contains(right) && wordBreak(left, dict)) {
                mem.put(s, true);
                return true;
            }
        }
        // No solution
        mem.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        WordBreak sol = new WordBreak();
        System.out.println(sol.wordBreak(s, wordDict));
    }
}
