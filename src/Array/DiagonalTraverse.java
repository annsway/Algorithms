package Array;

import java.util.Arrays;

public class DiagonalTraverse {
    public int[] findDiagonalTraverse (int[][] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int ROWS = array.length;
        int COLS = array[0].length;
        int[] res = new int[ROWS * COLS];
        int res_i = 0;
        for (int idxSum = 0; idxSum <= (ROWS - 1 + COLS - 1); idxSum++) {
            for (int i = 0; i <= idxSum; i++) {
                int j = idxSum - i;
                int ii, jj;
                if(idxSum % 2 == 1) {
                    ii = i;
                    jj = j;
                } else {
                    ii = j;
                    jj = i;
                }
                if (ii<ROWS && jj<COLS) {
                    res[res_i++] = array[ii][jj];
                }
            }
        }
        return res;
    }
    /** idxSum = 3
     *  i = 0
     *  j = 3
    */

    /**
     i: 0   0 0   1 2   1
     j: 0   1 1   1 0   2

    ii: 0   0 1   1 0   1
    ji: 0   1 0   1 2   2
     s: 0   1 1   2 2   3
     */

    public static void main(String[] args) {
        DiagonalTraverse sol = new DiagonalTraverse();
        System.out.println(Arrays.toString(sol.findDiagonalTraverse(
                new int[][]{{1, 2, 3},
                            {4, 5, 6}})));
    }
}
