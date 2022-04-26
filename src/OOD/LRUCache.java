package OOD;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> cache;
    // HashMap: <key = node_value, value = node_address>
    int capacity;
    int size;

    public LRUCache(int cap) {
        // dummy head and dummy tail
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        this.capacity = cap;
        this.size = 0;
        cache = new HashMap<>();
    }

    public int get(int key) {
        int res = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            res = node.val;
            moveToHead(node);
        }
        return res;
    }

    private void moveToHead(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        // 1. existing node
        if (node != null) {
            node.val = value; // update value
            moveToHead(node);
        } else {
            // 2. new node
            node = new Node(key, value);
            if (size < capacity) {
                size++;
            } else {
                popTail();
            }
            addNode(node);
            cache.put(key, node);
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void popTail() {
        Node newTail = tail.prev.prev;
        newTail.next = tail;
        tail.prev = newTail;
    }

    static class Node {
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache sol = new LRUCache(2);
        sol.put(1,1);
        sol.put(2,2);

        sol.get(1);
        System.out.println(sol.get(1));
        System.out.println(sol.get(2));

        sol.put(3,3);
        System.out.println(sol.get(2));// -1

    }
}
