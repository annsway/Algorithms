package UnionFind;

public class NumOfConnectedNodes {
    public int countComponents(int n, int[][] edges) {
        UnionFindSet ufs = new UnionFindSet(n);
        int count = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            ufs.union(x, y);
        }
        int[] root = ufs.root;
        for (int i = 0; i < n; i++) {
            if (root[i] == i) {
                count++;
            }
        }
        return count;
    }

    static class UnionFindSet {
        int[] root;
        int[] rank;

        public UnionFindSet(int n) {
            this.root = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] == rank[rootY]) {
                    root[rootX] = rootY;
                    rank[rootY] += 1;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                }
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        NumOfConnectedNodes sol = new NumOfConnectedNodes();
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(sol.countComponents(5, edges)); // expected: 1
    }
}

