package Simulation;

public class RhombicBorderSum {

    public int maxBorderSum(int[][] matrix, int radius) {
        int max = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (isRhombic(matrix.length, matrix[0].length, r, c, radius)) {
                    int sum = calBorderSum(matrix, r, c, radius);
                    max = Math.max(max, sum);
                    System.out.println("center (" + r + ", " + c + ") " + sum);
                }
            }
        }
        return max;
    }

    private boolean isRhombic(int ROWS, int COLS, int r, int c, int radius) {
        if (r - radius + 1 >= 0 && r + radius - 1 < ROWS &&
                c - radius + 1 >= 0 && c + radius - 1 < COLS) {
            return true;
        }
        return false;
    }

    private int calBorderSum(int[][] matrix, int r, int c, int radius) {
        int top = r - radius + 1, right = c + radius - 1,
                bottom = r + radius - 1, left = c - radius + 1;
        int sum = 0;

        int i = top, j = c;
        System.out.println("i: " + i + " j:" + j);
        for (int k = 0; k < right - c; k++) {
            System.out.println(matrix[i][j]);
            sum += matrix[i][j];
            i += 1;
            j += 1;
        }
        for (int k = 0; k < bottom - r; k++) {
            System.out.println(matrix[i][j]);
            sum += matrix[i][j];
            i += 1;
            j -= 1;
        }
        for (int k = 0; k < c - left; k++) {
            System.out.println(matrix[i][j]);
            sum += matrix[i][j];
            i -= 1;
            j -= 1;
        }
        for (int k = 0; k < r - top; k++) {
            System.out.println(matrix[i][j]);
            sum += matrix[i][j];
            i -= 1;
            j += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 0, 4, 2, 7, 3},
                {6, 2, 7, 2, 1, 1},
                {4, 1, 4, 5, 3, 0},
                {3, 5, 2, 1, 4, 6},
                {3, 4, 6, 1, 0, 4},
                {3, 4, 6, 1, 0, 4}};

        RhombicBorderSum sol = new RhombicBorderSum();
        System.out.println(sol.maxBorderSum(matrix, 3)); // 31

    }
}
