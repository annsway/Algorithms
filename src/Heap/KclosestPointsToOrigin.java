package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k);
        for (int[] point : points) {
            Cell cell = new Cell(point[0], point[1]);
            if (maxHeap.size() < k) {
                maxHeap.offer(cell);
            } else {
                if (maxHeap.peek().dist > cell.dist) {
                    maxHeap.poll();
                    maxHeap.offer(cell);
                }
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Cell cell = maxHeap.poll();
            res[i][0] = cell.x;
            res[i][1] = cell.y;
        }
        return res;
    }

    static class Cell implements Comparable<Cell> {
        int x;
        int y;
        double dist;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x * x + y * y);
        }

        @Override
        public int compareTo(Cell o2) {
            if (this.dist == o2.dist) {
                return 0;
            }
            return this.dist > o2.dist ? -1 : 1;
        }
    }

    public static void main(String[] args) {
//        int[][] input = {{3,3},{5,-1},{-2,4},{9, 9}};// points = [[3,3],[5,-1],[-2,4]], k = 2
        int[][] input ={{3,3},{5,-1},{-2,4}};
        KclosestPointsToOrigin sol = new KclosestPointsToOrigin();
        System.out.println(Arrays.deepToString(sol.kClosest(input, 2)));
    }
}

// TC: O(nlogk)
// SC: O(k)