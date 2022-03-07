package String;

public class ImplRegEx {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // M[i][j] represents whether or not the substring of s between [0, i] matches
        //         with the pattern p between [0, j]
        boolean[][] M = new boolean[s.length() + 1][p.length() + 1];
        // initialize M
        M[0][0] = true; // an empty string matches an empty pattern
        for (int j = 1; j < M[0].length; j++) {
            if (p.charAt(j - 1) == '*') {
                M[0][j] = M[0][j - 2]; // to deal with cases where the 2nd char pattern is '*'
            }
        }
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                // case 1: compare directly
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    M[i][j] = M[i - 1][j - 1];
                }
                // case 2: encounter '*'
                else if (p.charAt(j - 1) == '*') {
                    // case 2.1: not take any char from 'a*'
                    M[i][j] = M[i][j - 2];
                    // case 2.2: take at least one 'a' from 'a*'
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') { // test case: "aaa", ".*"
                        M[i][j] = M[i][j] || M[i - 1][j]; // takes whichever is true. test case: "aaa", "ab*a*c*a"
                    }
                } else {
                    M[i][j] = false;
                }
            }
        }
        return M[s.length()][p.length()];
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aab", "c*a*b")); //  s = "aab", p = "c*a*b"
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("mississippi", "mis*is*p*."));
//        System.out.println(isMatch("aaa", "ab*a*c*a"));
        System.out.println(isMatch("aaa", ".*"));
    }
}



