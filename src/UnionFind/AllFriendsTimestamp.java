package UnionFind;

public class AllFriendsTimestamp {
    public int earliestAcq(int[][] logs, int n) {
        UnionFindSet ufs = new UnionFindSet(n);
        for (int i = 0; i < logs.length; i++) {
            int timestamp = logs[i][0];
            int x = logs[i][1];
            int y = logs[i][2];
            // if (ufs.allConnected()) {
            //     return timestamp;
            // }
            if (ufs.union(x, y)) {
                n--;
            }
            if (n == 1) {
                return timestamp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3},{20190312,1,2},{20190322,4,5}};
        AllFriendsTimestamp sol = new AllFriendsTimestamp();
        System.out.println(sol.earliestAcq(logs, 6)); // expected: 20190301
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
                return root[x];
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

        public boolean allConnected() {
            for (int i = 1; i < root.length; i++) {
                if (!isConnected(i, i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}