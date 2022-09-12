package DP;

import java.util.*;

public class WordBreak {
    public static boolean canBreak(String input, String[] dict) {
        Set<String> set = new HashSet<>(Arrays.asList(dict));
        int n = input.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // i represents the index of dp[], and represents index (i - 1) in input
        // dp[i] represents whether or not substring [0, i - 1] in input can be
        //  broken into words in dict
        // dp[0] = true
        // induction rule: dp[i] = substring[0, i - 1] || (dp[j] && substring[j, i])
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(input.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
//    private Map<String, Boolean> mem = new HashMap<>();
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict = new HashSet<>(wordDict);
//        // recursion
//        return wordBreak(s, dict);
//    }
//    public boolean wordBreak(String s, Set<String> dict) {
//        // base case 1
//        if (mem.containsKey(s)) {
//            return mem.get(s);
//        }
//        // base case 2: if the entire string s is a word
//        if (dict.contains(s)) {
//            mem.put(s, true);
//            return true;
//        }
//        for (int i = 1; i < s.length(); i++) {
//            String left = s.substring(0, i);
//            String right = s.substring(i);
//            // find solution for s
//            if (dict.contains(right) && wordBreak(left, dict)) {
//                mem.put(s, true);
//                return true;
//            }
//        }
//        // No solution
//        mem.put(s, false);
//        return false;
//    }

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
//        System.out.println(sol.canBreak("robcatd", new String[]{"rob","cat","d"})); // true
        System.out.println(sol.canBreak("a", new String[]{"a","b","d"})); // true


//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        WordBreak sol = new WordBreak();
//        System.out.println(sol.wordBreak(s, wordDict));
    }
}
