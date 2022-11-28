package DP;

public class CountPalindromicSubstrings {
    public static int countSubstrings(String s) {
        int n = s.length(), res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int c = 0; c < n; c++) {
            for (int r = c; r >= 0; r--) {
                if (r == c) {
                    // a: 最中间是奇数palindrome
                    dp[r][c] = true;
                    res++;
                } else if (r == c - 1 && s.charAt(r) == s.charAt(c)) {
                    // [aa]：最中间是偶数palindrome
                    dp[r][c] = true;
                    res++;
                } else if (dp[r + 1][c - 1] && s.charAt(r) == s.charAt(c)) {
                    // a{中间}b：中间是palindrome
                    dp[r][c] = true;
                    res++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(CountPalindromicSubstrings.countSubstrings("fdsklf"));
        System.out.println(CountPalindromicSubstrings.countSubstrings("aaa"));
    }
}
