package DP;

public class LongestSubsequence {
    public static int longest(String source, String target) {
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            return 0;
        }
        int n = source.length();
        int m = target.length();
        int[][] M = new int[n + 1][m + 1];
        // M[i][j] represents the longest common subsequence from index 0 to index i at source array and index j at target array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                } else {
                    M[i][j] = Math.max(M[i][j - 1], M[i - 1][j]);
                    // 当 current char 没有匹配上的时候
                    // M[i][j - 1]: 查看 current source 和 previous target 的最大匹配结果
                    // M[i - 1][j]: 查看 previous source 和 current target 的最大匹配结果
                    // Q：为什么不看 M[i - 1][j - 1]?
                    // A: 因为 M[i - 1][j - 1] 代表了 source 和 target 长度都不增加的最大匹配结果
                }
            }
        }
        return M[n][m];
    }

    public static void main(String[] args) {
//        System.out.println(longest("af","abf"));
        System.out.println(longest("aaaaa", "abbaba")); // expected: 3
    }
}
