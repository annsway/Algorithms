package DP;

public class LongestCommonSubstring {
    public static String longestCommon(String source, String target) {
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            return "";
        }
        int n = source.length();
        int m = target.length();
        int[][] M = new int[n + 1][m + 1];
        int globalMax = M[0][0];
        int tempStart = 0;
        // M[i][j] represents the longest common substring between source[0, i] and target[0, j].
        int start = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                    tempStart = j - M[i][j];
                }
                if (globalMax < M[i][j]) {
                    globalMax = M[i][j];
                    start = tempStart;
                }
            }
        }
        return target.substring(start, start + globalMax);
    }

    public static void main(String[] args) {
        System.out.println(longestCommon("abccddefffghhh", "bdhghhf")); // expected: "ghh"
        System.out.println(longestCommon("aaaaaa", "")); // expected: ""
        System.out.println(longestCommon("aaaaaa", "bbaaba")); // expected: "aa"
        System.out.println(longestCommon("abcde", "cdf")); // expected: "cd"
    }
}
