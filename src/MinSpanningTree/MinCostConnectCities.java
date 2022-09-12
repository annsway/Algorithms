package MinSpanningTree;

import java.util.*;

public class MinCostConnectCities {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind();
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));

        for (int[] connection : connections) {
            uf.add(connection[0]);
            uf.add(connection[1]);
        }
        int minCost = 0; // result
        for (int[] con : connections) {
            if (!uf.isConnected(con[0], con[1])) {
                uf.union(con[0], con[1]);
                minCost += con[2];
            }
        }
        return uf.numSets == 1 ? minCost : -1;
    }

    static class UnionFind {
        private Map<Integer, Integer> map;  // <node, parentNode/root>
        private int numSets;

        public UnionFind() {
            this.map = new HashMap<>();
            this.numSets = 0;
        }

        public void add(int num) {
            if (!map.containsKey(num)) {
                map.put(num, null);
                this.numSets++;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                map.put(x, rootY);
                this.numSets--;
            }
        }

        public int find(int x) {
            int root = x;
            while (map.get(root) != null) {
                root = map.get(root); // only parent node has parent of null
            }
            // path compression
            while (x != root) {
                int parent = map.get(x);
                map.put(x, root);
                x = parent;
            }
            return root;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int getNumSets() {
            return this.numSets;
        }
    }
}
