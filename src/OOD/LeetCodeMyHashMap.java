package OOD;

public class LeetCodeMyHashMap {
    Node[] array;
    int size;
    int capacity = 2069;

    public LeetCodeMyHashMap() {
        this.array = new Node[capacity];
        this.size = 0;
    }

    public void put(int key, int value) {
        int index = getHashCode(key);
        Node head = array[index];
        Node cur = head;
        if (cur == null) {
            head = new Node(key, value);
        } else {
            // search if (key, value) already exists
            while (cur != null) {
                if (cur.key == key) {
                    cur.val = value; //update
                    return;
                }
                cur = cur.next;
            }
            Node newHead = new Node(key, value);
            newHead.next = head;
            head = newHead;
        }
        array[index] = head;
    }

    private int getHashCode(int key) {
        return key % capacity;
    }

    public int get(int key) {
        int index = getHashCode(key);
        Node head = array[index];
        while (head != null) {
            if (head.key == key) {
                System.out.println(head);
                return head.val;
            }
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = getHashCode(key);
        Node head = array[index];
        Node prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    head = head.next;
                    array[index] = head;
                }
                break;
            }
            prev = head;
            head = head.next;
        }
    }

    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LeetCodeMyHashMap hashMap = new LeetCodeMyHashMap();
        hashMap.put(1, 11);
        hashMap.put(2, 22);
        hashMap.put(20, 202);
        System.out.println(hashMap.get(1));

        hashMap.put(1, 99);
        System.out.println(hashMap.get(1));

        hashMap.remove(1);
        System.out.println(hashMap.get(1));

    }
}
