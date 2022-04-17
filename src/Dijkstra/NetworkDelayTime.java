package Dijkstra;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build the graph (edges) using hash map => Map<src, {travelTime, dest}>
        Map<Integer, List<List<Integer>>> adjList = new HashMap<>();
        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int travelTime = time[2];

            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            adjList.get(src).add((Arrays.asList(travelTime, dest)));
        }
        int[] weightTable = new int[n + 1];
        Arrays.fill(weightTable, Integer.MAX_VALUE);

        // dijkstra algorithm -- O(ElogV)
        Queue<List<Integer>> minHeap =
                new PriorityQueue<>((o1, o2) -> o1.get(0).compareTo(o2.get(0)));
        // starting node k (has 0 travel time to itself)
        minHeap.offer(Arrays.asList(0, k));
        weightTable[k] = 0;

        while (!minHeap.isEmpty()) {
            List<Integer> cur = minHeap.poll();
            int curTravelTime = cur.get(0);
            int curNode = cur.get(1);

            if (curTravelTime > weightTable[curNode]) {
                continue;
            }

            // skip if cur node does not have any outgoing edges e.g. node1, otherwise, NPE
            if (!adjList.containsKey(curNode)) {
                continue;
            }

            for (List<Integer> edge : adjList.get(curNode)) {
                int neiTime = edge.get(0);
                int neiNode = edge.get(1);

                int weight_old = weightTable[neiNode];
                int weight_new = curTravelTime + neiTime;

                if (weight_new < weight_old) {
                    weightTable[neiNode] = weight_new;
                    minHeap.offer(Arrays.asList(weight_new, neiNode));
                }
            }
        }

        // result
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) { // O(V)
            res = Math.max(res, weightTable[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        NetworkDelayTime sol = new NetworkDelayTime();
        System.out.println(sol.networkDelayTime(
                new int[][]{
                        {2, 1, 1},
                        {2, 3, 1},
                        {3, 4, 1}}, 4, 2)); // expected: 2
    }
}
