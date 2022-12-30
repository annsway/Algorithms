package Matrix;

import java.util.Arrays;

public class RotateOverDiagonal {
    public int[][] rotateMatrix(int[][] matrix, int turns) {
        int n = matrix.length;
        int k = turns % 4;
        while (k > 0) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    if (i != j && (i + j) != (n - 1)) {
                        rotate(matrix, i, j);
                    }
                }
            }
            k--;
        }
        return matrix;
    }

    private void rotate(int[][] matrix, int i, int j) {
        int n = matrix.length;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = temp;
    }

    public static void main(String[] args) {
        RotateOverDiagonal sol = new RotateOverDiagonal();
        int[][] matrix =   {{1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20},
                            {21, 22, 23, 24, 25}};

        System.out.println(Arrays.deepToString(sol.rotateMatrix(matrix, 3)));
    }
}