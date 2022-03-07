package Heap;

import java.util.PriorityQueue;

public class KthSmallestSumSorted {
    public int kthSum(int[] A, int[] B, int k) {
        Cell[][] sums = new Cell[A.length][B.length];
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sums[i][j] = new Cell(A[i], B[j]);
                if (maxHeap.size() < k) {
                    maxHeap.offer(sums[i][j]);
                } else if (maxHeap.peek().val > sums[i][j].val) {
                    maxHeap.poll();
                    maxHeap.offer(sums[i][j]);
                }
            }
        }
        return maxHeap.peek().val;
    }

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.val = x + y;
        }

        // implement max heap
        @Override
        public int compareTo(Cell another) {
            if (this.val == another.val) {
                return 0;
            }
            return this.val > another.val ? -1 : 1;
        }
    }
    public static void main(String[] args) {
        KthSmallestSumSorted sol = new KthSmallestSumSorted();
        System.out.println(sol.kthSum(new int[]{1, 3, 5}, new int[]{4, 8}, 2));
    }
}
