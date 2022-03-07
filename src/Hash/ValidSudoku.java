package Hash;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        Set<Character>[] rows = new HashSet[N];
        Set<Character>[] cols = new HashSet[N];
        Set<Character>[][] boxes = new HashSet[N/3][N/3];
        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                // get the box index
                int rBox = r / 3;
                int cBox = c / 3;
                Set<Character> box = boxes[rBox][cBox] == null ? new HashSet<>() : boxes[rBox][cBox];

                if (board[r][c] == '.') {
                    continue;
                } else if (rows[r].contains(board[r][c]) || cols[c].contains(board[r][c]) || box.contains(board[r][c]) ) {
                    return false;
                } else {
                    rows[r].add(board[r][c]);
                    cols[c].add(board[r][c]);
                    box.add(board[r][c]);
                    boxes[rBox][cBox] = box;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] input = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};
        char[][] input = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        ValidSudoku sol = new ValidSudoku();
        System.out.println(sol.isValidSudoku(input));
    }
}
