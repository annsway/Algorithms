package OOD;

import java.util.Arrays;

/**
 * For the following operations in HashMap
 * - boolean containsKey(Object key)
 * - V get(Object key)
 * - V put(K key, V value)
 * - V remove(Object key)
 *
 * TC:
 * average: O(1.75k) ~= O(1) // k is the length of the key; k (getIndex(key)) + 0.75k (0.75 calls for equals(cur.key, key))
 * worst case: O(n) // n is the number of elements in the hash map (when all the elements shared
 *                  the same index and were all resided in the same Node (in a linked list)
 *
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMapAns<K, V> {

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here.
     */
    private Node<K, V>[] array;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size;
    private final float loadFactor;

    public MyHashMapAns() {
        // if user did not enter capacity or loadFactor, use default
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); // 调用有参constructor
    }
    public MyHashMapAns(int capacity, float loadFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The capacity of HashMap cannot be negative!");
        }
        this.array = (Node<K, V>[]) (new Node[capacity]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    /**
     * value will always be non-negative.
     */
    public V put(K key, V value) {
        // calculate the index of the key
        int index = getIndex(key);

        // You don't need to check if array[index] has been occupied or not, since the new node will be the head of the Linked List anyways.
        Node<K, V> cur = array[index]; // can be null
        Node<K, V> head = array[index];
        // must keep head node, since there can be other nodes attached to the linked list for array[index] position for case 2
        // cur will be traversed, as a result, head might be lost where array[index] is not null
        while (cur != null) {
            // traverse linked list
            // case 1: the key already exist in the linked list - we need to replace it with the new value
            if (equalsKey(cur.key, key)) {
                cur.value = value;
                return value;
            }
            cur = cur.next;
        }
        // case 2: the key does not exist in any node in the linked lists of the array
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head; // attach new Node to the head of the linked list
        array[index] = newNode;
        size++;
        // check if hash map need rehash
        if (needRehash()) {
            rehash();
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        this.size = 0;
//        this.array = null; // this will not clear the data in heap
        Arrays.fill(this.array, null);
    }

//    private boolean equalsValue(V v1, V v2) {}

//    public boolean containsValue(V value) {}


    public boolean containsKey(Object key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        // test hash collision // int hashCode = (int) key.toString().charAt(0) * 101;  // bad hash function
        // rolling hash
        int hashCode = key.hashCode() * 101; // + a * 101^2 ..
        return hashCode & 0x7FFFFFFF; // guarantee a positive number
    }
    /** example:
     *   0111 1111 ...
     *   1011 0010 ...
     * & 0011 0010 ...
     * */

    private int getIndex(Object key) {
        return hash(key) % array.length;
    }

    private boolean needRehash() {
        return array.length * loadFactor < size;
    }

    private boolean equalsKey(K curKey, Object key) {
        return curKey == key || curKey != null && curKey.equals(key);
    }

    private void rehash() {
        Node<K, V>[] oldArray = array;
        Node<K, V>[] newArray = (Node<K, V>[]) (new Node[array.length * 2]);
        array = newArray;
//        size = 0; // no need to reset size! rehash -- size stays the same!
        for (Node<K, V> cur : oldArray) { // traverse the entire array
            while(cur != null) { // 撸链表
                int index = getIndex(cur.key);
                Node<K, V> next = cur.next;
                cur.next = newArray[index]; // new node becomes the head; case 1: newArray[index] is null; case 2: newArray[index] already exists
                newArray[index] = cur;
                cur = next;
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public V get(Object key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        while (cur != null) {
//            if (cur.key.equals(key)) { // WRONG! key can be NULL
            if (equalsKey(cur.key, key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }


    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public V remove(Object key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        Node<K, V> prev = null;
        while (cur != null) {
            // if head node is the one to be removed
            if (equalsKey(cur.key, key)) {
                if (prev == null) { // meaning cur is the head of the linked list to be removed
                    array[index] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null; // cannot find the node to be removed
    }

    public int getSize() {
        return this.size;
    }
}

class Test {
    public static void main(String[] args) {
//        MyHashMap<Integer, Integer> map = new MyHashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
//        map.put(null, 30);
//        map.remove(2);
//        System.out.println(map.get(1));
//        System.out.println(map.get(null));
//        System.out.println(map.get(2));
        // test rehash()
//        for (int i = 10; i < 30; i++) {
//            map.put(i, i * 10);
//        }
        // test hash collision
//        System.out.println("ab hash code is " + MyHashMap.hash("ab"));
//        System.out.println("ac hash code is " + MyHashMap.hash("ac"));

        MyHashMapAns<String, Integer> map2 = new MyHashMapAns<>();
        map2.put("ab", 1); // 1
        map2.put("ac", 2); // 2
        map2.put("ab1", 1); // 3
        map2.put("ac2", 2); // 4
        map2.put("ab3", 1); // 5
        map2.put("ac4", 2); // 6
        map2.put("ab5", 1); // 7
        map2.put("ac6", 2); // 8
        map2.put("ab7", 1); // 9
        map2.put("ac8", 2); // 10
        map2.put("ab9", 1); // 11
        map2.put("ac0", 2); // 12
        map2.put("abb", 1); // 13 --- reach to 0.75
        map2.put("acb", 2);
        map2.put("abbb", 1);
        map2.put("acbbb", 2);
        map2.put("abcc", 1);
        map2.put("test", 200);
        map2.put(null, 999);

//        System.out.println(map2.get("ab"));
//        System.out.println(map2.get("ac"));
//        map2.get("ac");

        System.out.println(map2.containsKey(null));

        // test capacity exception
//        MyHashMap<Integer, Integer> map3 = new MyHashMap<>(-1, 0.75f);
/**
 * Exception in thread "main" java.lang.IllegalArgumentException: The capacity of HashMap cannot be negative!
 * 	at HashMap.MyHashMap.<init>(MyHashMapAns.java:39)
 * 	at HashMap.Test.main(MyHashMapAns.java:210)
 * */
    }

}
