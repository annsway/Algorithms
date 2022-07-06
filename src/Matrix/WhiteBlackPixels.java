package Matrix;

import java.util.Arrays;

/**
 * You are given a black & white image in form of m * n pixel matrix grid.
 *
 * - if pixel[i][j] = 0 then pixel is black
 * - if pixel[i][j] = 1 then pixel is white
 *
 * Calculate maximum grayness of image.
 * Where grayness of a pixel[i][j]
 * = (number of 1s in ith row + number of 1s in jth column)
 * - (number of 0s in ith row + number of 0s in jth column)
 *
 * My Approach:
 *
 * Calculated the total number of 1s in each row and each column (row_1s array and col_1s array) using simple prefix array
 * number of 0s in a row = m - number of 1s
 * let number of 1s in ith row is x and number of 1s in jth column is y then number of 0s in ith row = m - x
 * and number of 0s in jth column = n - y
 * greyness = (x + y) - (m - x + n - y) = 2*(x + y) - (m + n)
 * used nested for loops to iterate over all pixels and checked for the maximum greyness overall.
 * Time Complexity: O(m*n)
 * Space Complexity: O(n)
 * */
public class WhiteBlackPixels {
    public int[][] calculateGrayness(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[] row_1s = new int[ROWS];
        int[] col_1s = new int[COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                row_1s[i] += matrix[i][j];
            }
        }

        //Calculates sum of each column of given matrix
        for(int j = 0; j < COLS; j++){
            for(int i = 0; i < ROWS; i++){
                col_1s[j] += matrix[i][j];
            }
        }

        // result
        int[][] res = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                res[i][j] = (row_1s[i] + col_1s[j]) - (ROWS - row_1s[i] + COLS - col_1s[j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        WhiteBlackPixels sol = new WhiteBlackPixels();
        int[][] matrix = {
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 0}};
        System.out.println(Arrays.deepToString(sol.calculateGrayness(matrix)));
    }
}
