package Trie;

import java.util.*;

public class WordBreakII {

    TrieNode root;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.root = buildDict(wordDict);
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(s, 0, sb, root, res);
        return res;
    }

    private void backtrack(String s, int i, StringBuilder sb,
                           TrieNode node, List<String> res) {
        if (i == s.length()) {
            res.add(sb.toString());
            return;
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        while (i < s.length() && node != null) {
            node = node.children.get(s.charAt(i));
            sb.append(s.charAt(i));
            if (node != null && node.isWord) {
                backtrack(s, i + 1, sb, root, res);
            }
            i++;
        }
    }

    private TrieNode buildDict(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
        return root;
    }

    static class TrieNode {
        private boolean isWord;
        private Map<Character, TrieNode> children;

        TrieNode () {
            this.children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        WordBreakII sol = new WordBreakII();
        String s = "catsanddog";
        String[] str = {"cat","cats","and","sand","dog"};
        List<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println(sol.wordBreak(s, list));
    }
}
