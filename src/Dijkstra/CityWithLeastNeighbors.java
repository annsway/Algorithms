package Dijkstra;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CityWithLeastNeighbors {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], dist = edge[2];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new HashMap<>());
            }
            adjList.get(from).put(to, dist);
            if (!adjList.containsKey(to)) {
                adjList.put(to, new HashMap<>());
            }
            adjList.get(to).put(from, dist);
        }

        int resCount = Integer.MAX_VALUE;
        int resIndex = 0;

        for (int i = 0; i < n; i++) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            minHeap.offer(new int[]{i, 0});
            boolean[] visited = new boolean[n];
            int count = 0;

            while (!minHeap.isEmpty()) {
                int[] node = minHeap.poll();
                int cur = node[0], curDist = node[1];
                if (visited[cur]) {
                   continue;
                }
                visited[cur] = true;
//                if (!adjList.containsKey(cur)) {
//                    continue;
//                }
                count++; // every time a node pops up, its the shortest path is determined
                Map<Integer, Integer> neighbors = adjList.get(cur);
                for (Integer nei : neighbors.keySet()) {
                    int newDist = curDist + neighbors.get(nei);

                    if (newDist <= distanceThreshold && !visited[nei]) {
                        minHeap.offer(new int[]{nei, newDist});
                    }
                }
            }

            if (resCount >= count - 1) {
                System.out.println("count = " + (count - 1) + " i = " + i);
                resCount = count - 1;
                resIndex = i;
            }
        }

        return resCount == Integer.MAX_VALUE ? -1 : resIndex;
    }

    public static void main(String[] args) {
        System.out.println(CityWithLeastNeighbors.findTheCity(
                4, new int[][]{
                        {0,1,3},
                        {1,2,1},
                        {1,3,4},
                        {2,3,1}}, 4)); // 3
    }
}
