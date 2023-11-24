//package OOD;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MyHashMapAnsTestAns {
//
//    @Test
//    void put() {
//        MyHashMapAns<Integer, Integer> hm = new MyHashMapAns<>();
//        hm.put(1, 11);
//        hm.put(2, 22);
//        hm.put(3, 33);
//
//        hm.put(3, 39); // update key = 3
//
//        assertEquals(3, hm.getSize());
//        assertEquals(39, hm.get(3));
//
//        hm.put(10, 100);
//        hm.put(101, 1000);
//        assertEquals(1000, hm.get(101));
//        assertEquals(5, hm.getSize());
//
//        hm.remove(10);
//        assertNull(hm.get(10));
//        assertEquals(4, hm.getSize());
//        assertEquals(11, hm.get(1));
//
//        hm.put(11, 111);
//        hm.put(22, 222);
//        hm.put(33, 333);
//        assertEquals(111, hm.get(11));
//
//    }
//}