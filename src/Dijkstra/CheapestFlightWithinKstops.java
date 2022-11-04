package Dijkstra;


import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightWithinKstops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 如何表示 adjacency matrix
        int[][] adjMatrix = new int[n][n];
        for (int[] flight : flights) {
            adjMatrix[flight[0]][flight[1]] = flight[2]; // [from, to, cost]
        }
        // 同时记录 **`distances`** table 和 **`stops`** table
        int[] distances = new int[n];
        int[] stops = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);

        // set src to default 0
        distances[src] = 0;
        stops[src] = 0;

        // shortest path algo
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // by cost
        minHeap.offer(new int[]{src, 0, 0}); // <node, cost, num_stops>
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int node = cur[0], curDist = cur[1], curStops = cur[2];
            if (node == dst) {
                return curDist;
            }
            if (curStops == k + 1) {
                continue;
            }
            // 当 `nei` 满足以下**任意**一个条件时，需要重新加入队列，表示经过 `nei` 可能有 better path：
            // Shorter distance
            // Fewer stops
            for (int nei = 0; nei < n; nei++) {
                if (adjMatrix[node][nei] > 0) { // only if there is an edge
                    int nextDist = curDist + adjMatrix[node][nei];
                    int nextStops = curStops + 1;
                    // 1. better cost || 2. better stops
                    if (nextDist < distances[nei] || nextStops < stops[nei]) {
                        minHeap.offer(new int[]{nei, nextDist, nextStops});
                        distances[nei] = nextDist;
                        stops[nei] = nextStops;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(CheapestFlightWithinKstops.findCheapestPrice(
                4, new int[][]{
                        {0, 1, 100},
                        {1, 2, 100},
                        {2, 0, 100},
                        {1, 3, 600},
                        {2, 3, 200}},
                0,
                3,
                1
        )); // 700
    }
}
