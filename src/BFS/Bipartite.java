package BFS;

import java.util.*;

public class Bipartite {
    public static boolean isBipartite(List<GraphNode> graph) {
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode nei : cur.neighbors) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite2(List<GraphNode> graph) {
        // 0 = uncolored; 1 = red; 2 = green
        HashMap<GraphNode, Integer> colors = new HashMap<>();
        // record the neighboring nodes,
        // of which the color must be different than the color of the current node
        Queue<GraphNode> q = new ArrayDeque<>();
        q.offer(graph.get(0));
        colors.put(graph.get(0), 1);
        int visited = 0;
        while (!q.isEmpty()) {
            GraphNode cur = q.poll();
            int color = colors.get(cur);
            visited++;
            for (GraphNode nei : cur.neighbors) {
                if (!colors.containsKey(nei)) {
                    int neiColor = color == 1 ? 2 : 1;
                    colors.put(nei, neiColor);
                } else if (colors.get(nei) == color) {
                    return false;
                }
                q.offer(nei);
            }
        }
        return visited == graph.size();
    }

    public static void main(String[] args) {
        Bipartite sol = new Bipartite();
        /**
         input:
         {0->1;
         1->0,2,3;
         2->1,3;
         3->1,2}
         * */
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);

        // Add neighbors
        n0.addNeighbors(n1);
        n1.addNeighbors(n0, n2, n3);
        n2.addNeighbors(n1, n3);
        n3.addNeighbors(n1, n2);

        List<GraphNode> graph = new ArrayList<>();
        graph.add(n0);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);

        System.out.println(sol.isBipartite(graph));

    }


}
