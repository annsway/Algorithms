//package UnionFind;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class NumOfIslands {
//    public int numIslands(char[][] grid) {
//        int n = grid.length > grid[0].length ? grid.length : grid[0].length; // number of nodes
//        UnionFindSet ufs = new UnionFindSet(n);
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    count++;
//                    if (ufs.union(i, j)) {
//                        count--;
//                    };
//                }
//            }
//        }
//        return count;
//    }
//
//    static class UnionFindSet {
//        int[] root;
//        int[] rank; // height
//
//        // constructor
//        public UnionFindSet(int n) {
//            this.root = new int[n];
//            this.rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                root[i] = i;
//                rank[i] = 1;
//            }
//        }
//
//        public int find(int x) { // return the root node of x
//            if (x == root[x]) {
//                return root[x];
//            } else {
//                root[x] = find(root[x]);
//                return root[x];
//            }
//        }
//
//        public boolean union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) {
//                return false; // indicates x and y shared the same parent node
//            }
//            if (rank[rootX] < rank[rootY]) {
//                root[rootX] = rootY;
//            } else if (rank[rootX] > rank[rootY]) {
//                root[rootY] = rootX;
//            } else {
//                root[rootY] = rootX;
//                rank[rootX] += 1;
//            }
//            return true;
//        }
//
//        public boolean connected(int x, int y) {
//            return find(x) == find(y);
//        }
//    }
//    public static void main(String[] args) {
//        NumOfIslands sol = new NumOfIslands();
////        char[][] grid = {
////                {'1', '1', '0', '0', '0'},
////                {'1', '1', '0', '0', '0'},
////                {'0', '0', '1', '0', '0'},
////                {'0', '0', '0', '1', '1'}};
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}}; // 1
//        System.out.println(sol.numIslands(grid));
//    }
//}
