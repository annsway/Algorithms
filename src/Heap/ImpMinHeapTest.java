//package Heap;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ImpMinHeapTest {
//
//    @Test
//    void peek() {
//        ImpMinHeap minHeap = new ImpMinHeap(4);
//        minHeap.offer(5);
//        minHeap.offer(1);
//        minHeap.offer(3);
//        minHeap.offer(4);
//        assertEquals(1, minHeap.peek());
//        assertEquals(4, minHeap.size());
//    }
//
//    @Test
//    void poll() {
//        ImpMinHeap minHeap = new ImpMinHeap(4);
//        minHeap.offer(5);
//        minHeap.offer(1);
//        minHeap.offer(3);
//        minHeap.offer(4);
//        assertEquals(1, minHeap.poll());
//        assertEquals(3, minHeap.size());
//    }
//
//    @Test
//    void update() {
//        ImpMinHeap minHeap = new ImpMinHeap(4);
//        minHeap.offer(5);
//        minHeap.offer(1);
//        minHeap.offer(3);
//        minHeap.offer(4);
//        assertEquals(4, minHeap.update(1, 9));
//        assertEquals(4, minHeap.size());
//    }
//}