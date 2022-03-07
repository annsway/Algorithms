package Dijkstra;

import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        // Assumptions: the matrix is not null, N > 0 and M > 0; K > 0 and K <= N * M
        // Since the matrix is in ascending order, it can be guaranteed it's non-decreasing.
        // Thus, we can use Dijkstra algorithm to solve this problem.
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k);
        boolean[][] generated = new boolean[n][m];
        int[][] directions = {{0, 1}, {1, 0}};
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        generated[0][0] = true;
        while (!minHeap.isEmpty() && k > 1) { // ? k = 1 means
            Cell cur = minHeap.poll(); // expand
            k--; // ???
            for (int[] dir : directions) { // loop through every direction
                int x = cur.row + dir[0];
                int y = cur.col + dir[1];
                // 如何保证 一定是第k小？如果第二排的数都比第一排要大？
                if (x >= 0 && x < n && y >= 0 && y < m && !generated[x][y]) {
                    Cell cell = new Cell(x, y, matrix[x][y]);
                    minHeap.offer(cell);
                    generated[x][y] = true;
//                    k--; // ???
                }
            }
        }
        return minHeap.peek().val;

    }

    static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Cell another) {
            if (another == null) {
                return -1;
            }
            if (this.val == another.val) {
                return 0;
            }
            return this.val < another.val ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        KthSmallest sol = new KthSmallest();
        int[][] matrix = {{1,  2,  3,  4},
                         {11, 12, 13, 14},
                         {15, 16, 17, 18},
                         {19, 20, 21, 22}};
        System.out.println(sol.kthSmallest(matrix, 4)); // expected: 4
    }
}
