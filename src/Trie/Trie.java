package Trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
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

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode () {
            this.children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
    }
}
