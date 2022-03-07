package DP;

public class WildcardMatching {
    public static boolean match(String input, String pattern) {
        // M[i][j] represents whether or not the substring from index [0, i] of the input string matches
        //         with the substring from index [0, j] of the pattern string.
        boolean[][] M = new boolean[input.length() + 1][pattern.length() + 1];
        M[0][0] = true; // empty string matches with empty pattern
        // deal with pattern starting with '*' -- treat it as empty pattern string
        for (int j = 1; j < M[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') {
                M[0][j] = M[0][j - 1];
            }
        }
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                if (input.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    M[i][j] = M[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    M[i][j] = M[i - 1][j - 1] || M[i - 1][j] || M[i][j - 1]; //["abcdefg","a*?e?g*"]
                }
            }
        }
        return M[M.length - 1][M[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(match("abcdefg", "a*?e?g*"));
    }
}
