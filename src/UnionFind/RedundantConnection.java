package UnionFind;

import java.util.Arrays;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        // Idea: apply union() function to every edge. If two edges have already merged (shared the same parent node), then return false
        UnionFindSet s = new UnionFindSet(edges.length + 1);
        for (int[] edge : edges) {
            if (!s.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        RedundantConnection sol = new RedundantConnection();
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(sol.findRedundantConnection(edges)));
    }
}
class UnionFindSet {
    int[] root;
    int[] rank; // height

    // constructor
    public UnionFindSet(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) { // return the root node of x
        // method 1:
        // while (x != root[x]) { // root[x] is the parent node of x
        //     x = root[x]; // find the parent node of the parent node of x...
        // }
        // return x;
        // method 2: path compression
        if (x == root[x]) {
            return root[x];
        } else {
            root[x] = find(root[x]);
            return root[x];
        }
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false; // indicates x and y shared the same parent node
        }
        if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
        return true;
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}