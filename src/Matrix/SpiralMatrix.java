package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        // Write your solution here
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int i, j;
        int offset = 0;
        for (int layer = ROWS; layer > 0; layer -= 2) {
            // the center cell
            if (layer == 1) {
                res.add(matrix[offset][offset]);
                break;
            }
            // top layer
            i = offset;
            for (j = offset; j < COLS - 1 - offset; j++) {
                res.add(matrix[i][j]);
            }
            // right layer
            j = COLS - 1 - offset;
            for (i = offset; i < ROWS - 1 - offset; i++) {
                res.add(matrix[i][j]);
            }
            // bottom layer
            i = ROWS - 1 - offset;
            for (j = COLS - 1 - offset; j > offset; j--) {
                res.add(matrix[i][j]);
            }
            // left layer
            j = offset;
            for (i = ROWS - 1 - offset; i > offset; i--) {
                res.add(matrix[i][j]);
            }
            offset++;
        }

        return res;
    }
    public static void main(String[] args) {
        SpiralMatrix sol = new SpiralMatrix();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; // Output: [1,2,3,6,9,8,7,4,5]
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println(sol.spiralOrder(matrix));
    }
}
