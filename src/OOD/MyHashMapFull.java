package OOD;

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
 *                  the same index and were all placed in the same Entry (in a linked list)
 *
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMapFull<K, V> {
    private Entry<K, V>[] buckets;
    private int size;
    private int CAPACITY;
    private final double LOAD_FACTOR = 0.75;
    private final int SCALE_FACTOR = 2;

    public MyHashMapFull(int cap) {
        this.buckets = new Entry[cap];
        this.size = 0;
        this.CAPACITY = cap;
    }

    private void rehash() {
        Entry<K, V>[] oldBuckets = buckets;
        this.CAPACITY = this.CAPACITY * SCALE_FACTOR;
        buckets = new Entry[this.CAPACITY];
        for (Entry<K, V> entry : oldBuckets) {
            while (entry != null) { // traverse the old bucket (linked list)
                // temporarily store next node of the old bucket
                Entry<K, V> next = entry.next;
                // put current entry to the head of the hashed-to new bucket
                int index = getIndex(hash(entry.key));
                entry.next = buckets[index]; // new node becomes the head of the hashed-to new bucket
                buckets[index] = entry;
                entry = next;
            }
        }
    }

    private boolean needRehash() {
        return this.LOAD_FACTOR * CAPACITY < this.size;
    }

    private int hash(Object key) {
        // rolling hash
        int hashCode = key.hashCode() * 31;
        return hashCode & 0x7fffffff;
    }

    private int getIndex(Object key) {
        int hashCode = hash(key);
        return hashCode % this.CAPACITY;
    }

    public boolean containsKey(Object key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return false;
        }
        Entry<K, V> cur = buckets[index];
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public V get(Object key){
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        while (head != null) {
            if (equalsKey(head.key, key)) {
                return head.val;
            }
            head = head.next;
        }
        return null; // case 2. cannot find key
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> cur = head;
        while (cur != null) {
            if (equalsKey(cur.key, key)) { // case 1. key already exists in hash map
                cur.val = value; // update value
                return cur.val;
            }
            cur = cur.next;
        }
        // case 2. key does not exist
        Entry<K, V> newHead = new Entry<>(key, value);
        newHead.next = head;
        buckets[index] = newHead;

        this.size++;
        if (needRehash()) {
            rehash();
        }
        return buckets[index].val;
    }

    public V remove(Object key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return null;
        }
        Entry<K, V> prev = null;
        Entry<K, V> cur = buckets[index];
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    buckets[index] = cur.next;
                }
                this.size--;
                return cur.val;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getCap() {
        return this.CAPACITY;
    }

    public boolean equalsKey(K oldKey, Object key) {
        if (oldKey == key) return true;
        if (key == null) return false;
        K newKey = (K)key;
        return oldKey.equals(newKey);
    }

    static class Entry<K, V> {
        K key;
        V val;
        Entry<K, V> next;

        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyHashMapFull<Integer, Integer> hm = new MyHashMapFull<>(5);
        hm.put(1, 11);
        hm.put(2, 22);
        hm.put(3, 33);
        hm.put(3, 44);
        System.out.println(hm.size);

        MyHashMapFull<String, Integer> hm2 = new MyHashMapFull<>(5);
        hm2.put("A", 1);
        hm2.put("B", 2);
        hm2.put("C", 3);
        System.out.println(hm2.get("A"));
    }
}
