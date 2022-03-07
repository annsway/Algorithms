package DFS;

public class WordSearch {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(dfs(board, word, x, y, index + 1, visited)){
                return true;
            };
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {
//         {'A','B','C','E'}
//        ,{'S','F','C','S'}
//        ,{'A','D','E','E'}};
//        String word = "ABCCED"; // true
        char[][] board = {{'a'}};
        String word = "a"; // true

        WordSearch sol = new WordSearch();
        System.out.println(sol.exist(board, word));
    }
}
