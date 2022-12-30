package Trie;

import java.util.HashMap;
import java.util.Map;

public class CountPrefixPairs {
    TrieNode root = new TrieNode();

    public long solution(String[] words) {
        // build Trie
        for (String word : words) {
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(c);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                    cur.s = sb.toString();
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
        int res = 0;
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            res += countWordsWithPrefix(word);
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            System.out.println("word: " + word + " count: " + res);
        }
        // test case: 'a', 'a'
        for (Integer freq : freqMap.values()) {
            if (freq > 1) {
                res += freq * (freq - 1) / 2;
            }
        }
        return res;
    }

    public int countWordsWithPrefix(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode next = current.children.get(c);
            if (next == null) {
                // There are no words in the trie with the given prefix.
                return 0;
            }
            current = next;
        }
        return countWords(current) - 1; // do not count prefix itself
    }

    private int countWords(TrieNode node) {
        int count = 0;
        if (node.isWord) {
            count++;
        }
        for (TrieNode child : node.children.values()) {
            count += countWords(child);
        }
        return count;
    }

    static class TrieNode {
        boolean isWord;
        String s; //test
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public static long solution2(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]) || words[i].startsWith(words[j]) || words[j].startsWith(words[i])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String[] words = {"back", "backdoor", "gammon", "backgammon", "comeback", "come", "door"}; // 3
//        String[] words = {"abc", "a", "a", "b", "ab", "ac"}; // 8
        String[] words = {"a", "a", "a"}; // 3
        CountPrefixPairs sol = new CountPrefixPairs();
        System.out.println(sol.solution(words));
    }
}
