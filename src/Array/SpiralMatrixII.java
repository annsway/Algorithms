package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int offset = 0;
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        // left, right, top, and down indices serve as the offset
        int left = 0;
        int right = COLS - 1;
        int top = 0;
        int bottom = ROWS - 1;
        while (left < right && top < bottom) {
            // upper layer
            for (int col = left; col < right; col++) {
                res.add(matrix[top][col]);
            }
            // right layer
            for (int row = top; row < bottom; row++) {
                res.add(matrix[row][right]);
            }
            // bottom layer
            for (int col = right; col > left; col--) {
                res.add(matrix[bottom][col]);
            }
            // left layer
            for (int row = bottom; row > top; row--) {
                res.add(matrix[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        if (top > bottom || left > right) {
            return res;
        }
        // if there's one row left
        if (top == bottom) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
        } else if (left == right) { // if there's one col left
            for (int row = bottom; row >= top; row--) {
                System.out.println("top = " + top + ", bottom = " + bottom);
                res.add(matrix[row][left]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixII sol = new SpiralMatrixII();
//        System.out.println(sol.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(sol.spiralOrder(new int[][]{{3},{2}}));

    }
}
