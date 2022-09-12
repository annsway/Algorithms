package DP;

import java.util.ArrayList;
import java.util.List;

public class WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        // dp[i] represents whether substring [i, n - 1] can be broken down into words found in dict
        dp[n] = true; // base case
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int k = word.length();
                if (i + k <= n && word.equals(s.substring(i, i + k))) {
                    dp[i] = dp[i + k];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        WordBreakDP sol = new WordBreakDP();
        System.out.println(sol.wordBreak(s, wordDict)); // true
    }
}
