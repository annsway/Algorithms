package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        // pre-processing
        int n = board.length;
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[][] boxes = new HashSet[n / 3][n / 3];
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        // fill the hash sets based on board
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int rBox = r / 3;
                int cBox = c / 3;
                Set<Character> box = boxes[rBox][cBox] == null ? new HashSet<>() : boxes[rBox][cBox];
                Character cell = board[r][c];
                if (cell != '.') {
                    rows[r].add(cell);
                    cols[c].add(cell);
                    box.add(cell);
                }
                boxes[rBox][cBox] = box; // 必须写在外面，否则全是 '.' 的 box 无法被Initialize
            }
        }

        backtracking(board, rows, cols, boxes, n, 0); // starts from (0,0)
    }

    private boolean backtracking(char[][] board, Set<Character>[] rows, Set<Character>[] cols,
                                 Set<Character>[][] boxes, int n, int rc) {
        if (rc == n * n) { // base case: 当我们处理完最后一个 cell
            return true;
        }
        int row = rc / n;
        int col = rc % n;
        if (board[row][col] != '.') {
            return backtracking(board, rows, cols, boxes, n, rc + 1);
        }

        int rBox = row / 3;
        int cBox = col / 3;
        for (int i = 1; i <= n; i++) { // 从 1 到 9 填数独格子
            char val = (char) (i + '0'); // convert int to char
            if (!rows[row].contains(val) && !cols[col].contains(val) &&
                    !boxes[rBox][cBox].contains(val)) {
                // add
                board[row][col] = val;
                rows[row].add(val);
                cols[col].add(val);
                boxes[rBox][cBox].add(val);
                // call backtracking()
                if (backtracking(board, rows, cols, boxes, n, rc + 1)) {
                    return true;
                }
                // remove
                board[row][col] = '.';
                rows[row].remove(val);
                cols[col].remove(val);
                boxes[rBox][cBox].remove(val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SudokuSolver sol = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sol.solveSudoku(board);
//        char c = 9;
//        int num = (char) (c + '0');
//        System.out.println(num);
    }
}
