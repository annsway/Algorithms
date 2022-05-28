package DP;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j] represents the largest length of the palindromic substring found in the string with index from i to j, inclusively.
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) {
            for(int i = j; i >= 0; i--) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence sol = new LongestPalindromicSubsequence();
        String s = "bbbab";
        System.out.println(sol.longestPalindromeSubseq(s));
    }
}
// TC: O(N^2)
// SC: O(N^2)
