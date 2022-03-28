package Trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] array, int index, TrieNode root) {
        if (root == null) {
            return false;
        }
        if (index == array.length) {
            return root.isWord;
        }
        if (array[index] == '.') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                if (dfs(array, index + 1, entry.getValue())) {
                    return true;
                }
            }
        } else {
            TrieNode node = root.children.get(array[index]);
            return dfs(array, index + 1, node);
        }
        return false;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        WordDictionary sol = new WordDictionary();
        sol.addWord("bad");
        sol.addWord("dad");
        sol.addWord("mad");

        System.out.println(sol.search(".ad")); // true
    }
}
