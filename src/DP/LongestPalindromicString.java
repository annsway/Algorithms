package DP;

public class LongestPalindromicString {
    public String longestPalindrome(String input) {
        // Write your solution here
        if (input.length() == 0) {
            return input;
        }
        int n = input.length();
        // dp[i][j] represents if input.substring(i, j - i + 1) is palindrome
        // dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j)) if i < j - 1
        //          = s.charAt(i) == s.charAt(j) if i == j - 1
        //          = true                       if i == j
        //          = false                      else
        // ex. babab
        //     0  1  2  3  4
        //     b  a  b  a  b
        // 0 b t  f  t  f  t
        // 1 a    t  f  t  f
        // 2 b       t  f  t
        // 3 a          t  f
        // 4 b             t
        boolean[][] dp = new boolean[n][n];
        int globalMax = 0;
        int globalLeft = 0;
        for(int j = 0; j < n; j++) {
            for(int i = j; i >= 0; i--) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i == j - 1) {
                    dp[i][j] = input.charAt(i) == input.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (input.charAt(i) == input.charAt(j));
                }
                if (dp[i][j] && j + 1 - i > globalMax) {
                    globalMax = j + 1 - i;
                    globalLeft = i;
                }
            }
        }
        return input.substring(globalLeft, globalLeft + globalMax);
    }

    public static void main(String[] args) {
        LongestPalindromicString sol = new LongestPalindromicString();
        System.out.println(sol.longestPalindrome("abbc"));
    }
}
