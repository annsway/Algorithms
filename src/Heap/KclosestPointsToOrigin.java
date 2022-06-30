package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.dist == o1.dist ? 0 :
                o2.dist - o1.dist < 0 ? -1 : 1);
        for (int[] point : points) {
            Cell cur = new Cell(point[0], point[1]);
            if (!maxHeap.isEmpty() && maxHeap.size() == k && maxHeap.peek().dist > cur.dist) {
                maxHeap.poll();
            }
            maxHeap.offer(cur);
        }
        int[][] res = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Cell cur = maxHeap.poll();
            res[index][0] = cur.x;
            res[index][1] = cur.y;
            index++;
        }
        return res;
    }

    static class Cell {
        int x;
        int y;
        double dist;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Math.sqrt(x*x + y*y);
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