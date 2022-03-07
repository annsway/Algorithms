package OOD;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Node head, tail; // dummy head and tail of doubly linked list
    private int size;
    private Map<Integer, Node> cache;

    static class Node {
        int key; // LRUCache.put(key, value)
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // create dummy head and tail nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // move node to head
        moveToHead(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        // case 1: key exists
        if (node != null) {
            // update node value
            node.val = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            cache.put(key, node);
            addNode(node);

            if (this.size < this.capacity) { // case 2: key does not exist and cache is not full
                this.size++;
            } else { // case 3: key does not exist and cache is full
                // remove tail node
                Node tail = popTail();
                cache.remove(tail.key);
            }
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        // Do I need to check prev == null?
        prev.next = next;
        next.prev = prev;
    }

    private Node popTail() {
        Node res = this.tail.prev;
        removeNode(res);
        return res;
    }


    private void addNode(Node node) {
        // Add new node after dummy head
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }


    public static void main(String[] args) {
        LRUCache sol = new LRUCache(2);
        sol.put(1,1);
        System.out.println(sol.cache);

        sol.put(2,2);
        System.out.println(sol.cache);

        sol.get(1);
        System.out.println(sol.cache);

        sol.put(3,3);
        System.out.println(sol.cache);

        sol.get(2); // -1
        System.out.println(sol.cache);

    }
}
