package Hash;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(head, map);
    }
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node, copy);
        if (node.random != null) {
            Node randomCopy = dfs(node.random, map);
            copy.random = randomCopy;
        }
        if (node.next != null) {
            Node nextCopy = dfs(node.next, map);
            copy.next = nextCopy;
        }
        return copy;
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        CopyListWithRandomPointer sol = new CopyListWithRandomPointer();
        Node copyHead = sol.copyRandomList(n1);
        System.out.println(copyHead);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}