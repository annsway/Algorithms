package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给了一些itemAssociation, 如果一个item既在association A里面出现过，又在 association B里面出现过，
 * 那么就把A和B合并成一个association。求全部合 并后最大的association。
 * 如果两个association一样大，返回lexicographic order的第一个。
 * Input:String[][] itemAssociation
 * Return: String[]
 * Example:
 * Input: [itemA, itemB] [itemB, itemC] [itemD, itemE]
 * 合并之后:[itemA, itemB, itemC], [itemD, itemE]
 * Return: [itemA, itemB, itemC]
 * */
public class MergeAssociations {

    public static void main(String[] args) {
        String[][] itemAssociation = {{"itemA", "itemB"},{"itemB", "itemC"},{"itemD", "itemE"}};
        MergeAssociations sol = new MergeAssociations();

    }

    public String[] mergeAssociations(String[][] input) {
        UnionFind uf = new UnionFind();
        Map<String, List<String>> adjList = new HashMap<>();
        for (String[] set : input) {
            for (String v : set) {
                uf.add(v);
            }
        }
        return null;
    }

    static class UnionFind {
        private Map<String, String> map;
        private int numberOfSets;

        public UnionFind() {
            map = new HashMap<>();
            numberOfSets = 0;
        }

        public void add(String i) {
            if (map.containsKey(i)) {
                return;
            }
            map.put(i, null);
        }

        public boolean merge(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);

            if (rootX != rootY) {
                map.put(rootX, rootY);
                numberOfSets--;
                return true;
            }

            return false;
        }

        public String find(String x) {
            String root = x;
            while (map.get(root) != null) {
                root = map.get(root);
            }
            // path compression
            while (root != x) {
                String parent = map.get(x);
                map.put(x, root);
                x = parent;
            }
            return root;
        }

        public boolean isConnected(String x, String y) {
            return find(x) == find(y);
        }

        public int getNumOfSets() {
            return numberOfSets;
        }
    }
}
