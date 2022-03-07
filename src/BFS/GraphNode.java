package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;

    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<>();
    }
    public void addNeighbors(GraphNode... input) {
        neighbors.addAll(Arrays.asList(input));
        // for undirected graph, neighbors also point to the original node
        for (GraphNode nei : input) {
            if (!nei.neighbors.contains(this)) {
                nei.addNeighbors(this);
            }
        }
    }

}
class Graph {
    /**
    *  物理意义：
     *  - 每个 GraphNode 都是一个顶点
     *  - 每个 GraphNode 里的 neighbors 是一个list，需要往里面添加连接的其他 GraphNode
    * */

    public static void main(String[] args) {

        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);

        // Add neighbors
        n0.addNeighbors(n2, n3, n4);
        n1.addNeighbors(n0, n3);
        n2.addNeighbors(n3, n4);
        n3.addNeighbors(n1, n2, n4);
        n4.addNeighbors(n0, n2, n3);

        List<GraphNode> graph = new ArrayList<>();
        graph.add(n0);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);

        System.out.println(graph);

    }


    public static void ans() {
        List<GraphNode> nodes = IntStream.rangeClosed(1, 5).mapToObj(GraphNode::new).collect(Collectors.toList());
        nodes.get(1).neighbors = Arrays.stream(new int[]{2}).mapToObj(nodes::get).collect(Collectors.toList());
        nodes.get(2).neighbors = Arrays.stream(new int[]{1,3}).mapToObj(nodes::get).collect(Collectors.toList());
        nodes.get(3).neighbors = Arrays.stream(new int[]{2,4}).mapToObj(nodes::get).collect(Collectors.toList());
        nodes.get(4).neighbors = Arrays.stream(new int[]{3}).mapToObj(nodes::get).collect(Collectors.toList());
    }
}