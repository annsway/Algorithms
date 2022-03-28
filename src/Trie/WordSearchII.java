package Trie;

import java.util.*;

public class WordSearchII {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        // put words into Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        // dfs
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, sb, res, trie.root, visited, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, StringBuilder sb, Set<String> res, TrieNode root
            , boolean[][] visited, int row, int col) {
        TrieNode node = root.children.get(board[row][col]);
        if (node == null) {
            return;
        }
        visited[row][col] = true;
        sb.append(board[row][col]);
        if (node.isWord) {
            res.add(sb.toString());
//            return; // wrong!
        }
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                dfs(board, sb, res, node, visited, x, y);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
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
        WordSearchII sol = new WordSearchII();
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"}; // output: [oath, eat]
        System.out.println(sol.findWords(board, words));
//        System.out.println(sol.findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
}
