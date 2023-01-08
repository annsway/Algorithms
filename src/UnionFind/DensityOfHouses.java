package UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DensityOfHouses {

    public static void main(String[] args) {
        DensityOfHouses sol = new DensityOfHouses();
        int[] a = {2, 1, 3};
        System.out.println(Arrays.toString(sol.countSubarrayLen(a))); // output = [1, 2, 3]

        int[] b = {1, 3, 0, 4};
        System.out.println(Arrays.toString(sol.countSubarrayLen(b))); // output = [1, 1, 2, 2]

    }

    public int[] countSubarrayLen(int[] queries) {
        UnionFind uf = new UnionFind();
        int[] res = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            uf.add(query);

            int prev = query - 1;
            int next = query + 1;

            if (uf.exist(prev)) {
                uf.union(query, prev);
            }
            if (uf.exist(next)) {
                uf.union(query, next);
            }
            res[index++] = uf.getMaxSize();
        }
        return res;
    }

    static class UnionFind {
        Map<Integer, Integer> map; // <child, parent>
        int maxSize;
        int numSets;
        Map<Integer, Integer> sizeOfSet; // <root, size>

        UnionFind() {
            this.map = new HashMap<>();
            this.sizeOfSet = new HashMap<>();
        }

        void add(int x) {
            if (!map.containsKey(x)) {
                map.put(x, null);
                sizeOfSet.put(x, 1);
                maxSize = Math.max(maxSize, 1);
                numSets++;
            }
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                map.put(rootX, rootY);
                int size = sizeOfSet.get(rootX) + sizeOfSet.get(rootY);
                sizeOfSet.put(rootY, size);
                maxSize = Math.max(maxSize, size);
                numSets--;
            }
        }

        int find(int x) {
            int root = x;
            while (map.get(root) != null) {
                root = map.get(root);
            }
            // path compression
            while (x != root) {
                int parent = map.get(x);
                map.put(x, root);
                x = parent;
            }
            return root;
        }

        int getMaxSize() {
            return this.maxSize;
        }

        boolean exist(int x) {
            return map.containsKey(x);
        }
    }
}
