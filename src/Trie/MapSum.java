package Trie;

import java.util.HashMap;
import java.util.Map;
class MapSum {
    TrieNode root;
    Map<String, Integer> prefixSums = new HashMap<>();

    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        // update the prefix sum whenever there is a key inserted along the path
        int delta = val - prefixSums.getOrDefault(key, 0);
        for (char c : key.toCharArray()) {
            TrieNode node = cur.children.get(c);
            if (node == null) {
                node = new TrieNode();
                cur.children.put(c, node);
            }
            node.val += delta;
            cur = node;
        }
        prefixSums.put(key, val); // update hashmap
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode node = cur.children.get(c);
            if (node == null) {
                return 0; // prefix does not exist
            }
            cur = node;
        }
        return cur.val;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        int val;

        public TrieNode () {
            this.children = new HashMap<>();
        }
    }
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("app")); // expected: 5
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */