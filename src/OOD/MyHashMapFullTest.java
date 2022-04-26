package OOD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapFullTest {

    @Test
    void containsKey() {
        MyHashMapFull<Integer, Integer> hm = new MyHashMapFull<>(5);
        hm.put(1, 11);
        hm.put(2, 22);
        hm.put(3, 33);

        assertTrue(hm.containsKey(2));
        assertFalse(hm.containsKey(99));

        hm.remove(2);
        assertFalse(hm.containsKey(2));
    }

    @Test
    void put() {
        MyHashMapFull<Integer, Integer> hm = new MyHashMapFull<>(5);
        hm.put(1, 11);
        hm.put(2, 22);
        hm.put(3, 33);

        hm.put(3, 39); // update key = 3

        assertEquals(3, hm.getSize());
        assertEquals(39, hm.get(3));

        hm.put(10, 100);
        hm.put(101, 1000);
        assertEquals(1000, hm.get(101));
        assertEquals(5, hm.getSize());
        assertEquals(10, hm.getCap());

        hm.remove(10);
        assertNull(hm.get(10));
        assertEquals(4, hm.getSize());
        assertEquals(11, hm.get(1));

    }

    @Test
    void testString() {
        // test with <String, Integer>
        MyHashMapFull<String, Integer> hm = new MyHashMapFull<>(5);
        hm.put("A", 1);
        hm.put("B", 2);
        hm.put("C", 3);
        assertEquals(1, hm.get("A"));

        hm.remove("A");
        assertNull(hm.get("A"));
    }
}