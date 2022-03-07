package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KclosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((o1, o2) -> Double.compare(o2.distance, o1.distance)); // SC: O(k)
        for (int i = 0; i < points.length; i++) { // O(nlogk)
            int[] cur = points[i];
            Point point = new Point(cur[0], cur[1]);
            if (maxHeap.size() < k) {
                maxHeap.offer(point); // O(logk)
            } else if (!maxHeap.isEmpty() && maxHeap.peek().distance > point.distance) {
                maxHeap.poll();
                maxHeap.offer(point);
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) { // O(klogk)
            Point cur = maxHeap.poll();
            res[index][0] = cur.x;
            res[index][1] = cur.y;
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
//        int[][] input = {{3,3},{5,-1},{-2,4},{9, 9}};// points = [[3,3],[5,-1],[-2,4]], k = 2
        int[][] input = {{6,10},{-3,3},{-2,5},{0,2}}; // k = 3
        KclosestPointsToOrigin sol = new KclosestPointsToOrigin();
        System.out.println(Arrays.deepToString(sol.kClosest(input, 3)));
    }
}

class Point {
    int x;
    int y;
    double distance;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(x*x + y*y);
    }
}

// TC: O(nlogk)
// SC: O(k)