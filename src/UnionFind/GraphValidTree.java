package UnionFind;

public class GraphValidTree  {
    public boolean validTree(int n, int[][] edges) {
        UnionFindSet ufs = new UnionFindSet(n);
        int count = 0;
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!ufs.union(v1, v2)) {
                return false;
            } else {
                count++;
            }
        }

        return count == n - 1;
    }

    public static void main(String[] args) {
        GraphValidTree sol = new GraphValidTree();
        int[][] input = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(sol.validTree(5, input)); // true
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

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            } else {
                if (rank[rootX] == rank[rootY]) {
                    root[rootX] = rootY;
                    rank[rootY] += 1;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                }
                return true;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
