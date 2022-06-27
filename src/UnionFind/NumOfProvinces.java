package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfProvinces {
    public int findCircleNum(int[][] grid) {
        // convert adj matrix to adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && i != j) {
                    curList.add(j);
                }
            }
            adjList.add(curList);
        }
        int n = grid.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> curList = adjList.get(i);
            for (Integer j : curList) {
                uf.merge(i, j);
            }
        }
        return uf.getNumOfSets();
    }

    public static void main(String[] args) {
        NumOfProvinces sol = new NumOfProvinces();
        int[][] input = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,0},
                {1,0,1,1} };
        System.out.println(sol.findCircleNum(input));
    }
}

class UnionFind {
    private Map<Integer, Integer> map;
    private int numberOfSets;

    public UnionFind(int n) {
        map = new HashMap<>();
        numberOfSets = n;
        for (int i = 0; i < n; i++) {
            add(i);
        }
    }

    public void add(int i) {
        if (map.containsKey(i)) {
            return;
        }
        map.put(i, null);
    }

    public boolean merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            map.put(rootX, rootY);
            numberOfSets--;
            return true;
        }

        return false;
    }

    public int find(int x) {
        int root = x;
        while (map.get(root) != null) {
            root = map.get(root);
        }
        // path compression
        while (root != x) {
            int parent = map.get(x);
            map.put(x, root);
            x = parent;
        }
        return root;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getNumOfSets() {
        return numberOfSets;
    }
}