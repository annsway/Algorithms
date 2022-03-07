package DP;

public class InterleaveStrings {
    public boolean canMerge(String a, String b, String c) {
        // None of A, B, C is null
        if (a.length() + b.length() != c.length()) {
            return false;
        }
        boolean[][] M = new boolean[a.length() + 1][b.length() + 1];
        // M[i][j] represents whether or not the first i chars from A and first j chars from B can consist of the first k chars of C.
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 && j == 0) {
                    M[i][j] = true;
                } else if (i == 0) {
                    M[i][j] = M[i][j - 1] && (b.charAt(j - 1) == c.charAt(i + j - 1));
                } else if (j == 0) {
                    M[i][j] = M[i - 1][j] && (a.charAt(i - 1) == c.charAt(i + j - 1));
                } else if ((M[i - 1][j] || M[i][j - 1])
                        && (a.charAt(i - 1) == c.charAt(i + j - 1) || b.charAt(j - 1) == c.charAt(i + j - 1))) {
                    M[i][j] = true;
                }
            }
        }
        return M[a.length()][b.length()];
    }

    public static void main(String[] args) {
        InterleaveStrings sol = new InterleaveStrings();
        System.out.println(sol.canMerge("ab","ac","acab"));
        System.out.println(sol.canMerge("abgcd", "bebgf", "babebggcfd")); // expected: true
        System.out.println(sol.canMerge("aabcc", "dbbca", "aadbbcbcac")); // expected: true
        System.out.println(sol.canMerge("abgcd", "bebgf", "abgcdbebg"));
    }
}
