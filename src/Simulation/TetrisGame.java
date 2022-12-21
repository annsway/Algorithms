package Simulation;

public class TetrisGame {
    int solution(int[][] field, int[][] figure) {
        int m = field.length, n = field[0].length;
        for (int position = 0; position < n - 2; position++) {
            for (int r = m - 3; r >= 0; r--) {
                if (match(field, r, position, figure)) {
                    System.out.println("row: " + r + " position: " + position);
                    return position;
                }
            }
        }
        return -1;
    }

    private boolean match(int[][] field, int r, int c, int[][] figure) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[r + i][c + j] == 1 && figure[i][j] == 1) {
                    return false;
                }
            }
        }
        // check fully occupied row
        for (int i = 0; i < 3; i++) {
            int[] cur_row = new int[field[0].length];
            for (int j = 0; j < field[0].length; j++) {
                cur_row[j] = field[r + i][j];
            }
            for (int j = 0; j < 3; j++) {
                if (figure[i][j] == 1) {
                    cur_row[c + j] = figure[i][j];
                }
            }

            int j = 0;
            for (; j < field[0].length; j++) {
                if (cur_row[j] == 0) {
                    break;
                }
            }
            if (j == field[0].length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] field = {
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0},
//                {1, 0, 0},
//                {1, 1, 0}};
//
//        int[][] figure = {
//                {0, 0, 1},
//                {0, 1, 1},
//                {0, 0, 1}}; // Expected output: 0
        int[][] field = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1}};

        int[][] figure = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 0, 1}}; // Expected output: 2

        TetrisGame sol = new TetrisGame();
        int result = sol.solution(field, figure);
        System.out.println(result);

    }
}
