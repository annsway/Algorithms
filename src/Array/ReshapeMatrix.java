package Array;

import java.util.Arrays;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];
        int k = 0;
        int ROWS = mat.length;
        int COLS = mat[0].length;
        int[] temp = new int[ROWS * COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                temp[k++] = mat[i][j];
            }
        }
        k = 0;
        // put elements to the new matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (k >= temp.length) {
                    break;
                }
                res[i][j] = temp[k++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        ReshapeMatrix sol = new ReshapeMatrix();
        System.out.println(Arrays.deepToString(sol.matrixReshape(mat, 2, 4)));
    }
}
