package DP;

public class EditDistance {
    public static int editDistance(String one, String two) {
        // M[i][j] represents the minimum steps take to match the first j characters with
        // the first i characters.
        int[][] M = new int[one.length() + 1][two.length() + 1];
        M[0][0] = 0;
        for (int i = 0; i < one.length() + 1; i++) {
            for (int j = 0; j < two.length() + 1; j++) {
                if (i == 0) {
                    M[i][j] = j;
                } else if (j == 0) {
                    M[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1]; // do not increase step
                } else {
                    M[i][j] = Math.min(Math.min(M[i - 1][j], M[i][j - 1]), M[i - 1][j - 1]) + 1;
                }
            }
        }
        return M[one.length()][two.length()];
    }

    public static void main(String[] args) {
//        System.out.println(editDistance("ab","dbbabc"));
        System.out.println(editDistance("abbcc", "abbcc"));
    }
}
/**
 * test case: ("abbcc", "dbbabc")
     0 1 2 3 4 5 6
       d b b a b c
 0   0 1 2 3 4 5 6
 1 a 1 1 2 3 3 4 5
 2 b 2 2 1 2 3 3 4
 3 b 3 3(2)
 4 c 4
 5 c 5
 * test case: ("abbcc", "abbcc")
     0 1 2 3 4 5
       a b b c c
 0   0 1 2 3 4 5
 1 a 1 0
 2 b 2
 3 b 3
 4 c 4
 5 c 5

 * test case: ("ab","dbbabc")
     0 1 2 3 4 5 6
       d b b a b c
 0   0 1 2 3 4 5 6
 1 a 1 1 2 3 3 4 5
 2 b 2 2 1(2)3 3 4

 */
