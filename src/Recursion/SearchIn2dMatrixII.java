package Recursion;

public class SearchIn2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return helper(matrix, target, matrix.length / 2, matrix[0].length / 2);
    }

    private boolean helper(int[][] matrix, int target, int row, int col) {
        if (row < 0 || row == matrix.length || col < 0 || col == matrix[0].length) {
            return false;
        }
        if (matrix[row][col] == target) {
            return true;
        }
        if (matrix[row][col] < target &&
                (helper(matrix, target, row + row / 2, col + col / 2)
                        || helper(matrix, target, row + row / 2, col / 2)
                        || helper(matrix, target, row / 2, col + col / 2))) {
            return true;
        } else if (matrix[row][col] > target &&
                helper(matrix, target, row / 2, col / 2)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        SearchIn2dMatrixII sol = new SearchIn2dMatrixII();
        int[][] matrix={{1,  4,   7, 11, 15},
                        {2,  5,   8, 12, 19},
                        {3,  6,   9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
//        System.out.println(sol.searchMatrix(matrix, 5));
        System.out.println(sol.searchMatrix(matrix, 20));
    }
}
