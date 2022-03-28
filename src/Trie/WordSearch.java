package Trie;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        Trie trie = new Trie();
        trie.insert(word);
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, trie.root, sb, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, TrieNode root, StringBuilder sb,
                                 int row, int col, boolean[][] visited) {
        TrieNode node = root.children.get(board[row][col]);
        if (node == null) {
            return false;
        }
        sb.append(board[row][col]);
        System.out.println(sb);
        visited[row][col] = true;
        if (node.isWord) {
            return true;
        }
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                if (backtracking(board, node, sb, x, y, visited)) {
                    return true;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
        return false;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                TrieNode node = cur.children.get(c);
                if (node == null) {
                    node = new TrieNode();
                    cur.children.put(c, node);
                }
                cur = node;
            }
            cur.isWord = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        char[][] board = {{'o', 'a', 'a', 'n'},
                          {'e', 't', 'a', 'e'},
                          {'i', 'h', 'k', 'r'},
                          {'i', 'f', 'l', 'v'}};
        System.out.println(sol.exist(board, "oath"));
//        System.out.println(sol.findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
}
