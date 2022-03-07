package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class ReverseOrder {
    // Goal: reverse the natural order of Integer class (natural order: min heap)
    public static void main(String[] args) {
        // natural order of Integer class
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(99);
        minHeap.offer(-1);
        minHeap.offer(3);
        System.out.println("minHeap: ");
        while (minHeap.size() != 0) {
            System.out.println(minHeap.poll());
        }

        // 1. reversed order for Integer class:
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(99);
        maxHeap.offer(-1);
        maxHeap.offer(3);
        System.out.println("maxHeap:");
        while (maxHeap.size() != 0) {
            System.out.println(maxHeap.poll());
        }

        // 2. MyInteger2 has implemented Comparator as static nested class with natural order of min heap
        PriorityQueue<MyInteger2> reverseMinHeap = new PriorityQueue<>(Collections.reverseOrder(new MyInteger2.MyComparator()));
        reverseMinHeap.offer(new MyInteger2(99));
        reverseMinHeap.offer(new MyInteger2(-1));
        reverseMinHeap.offer(new MyInteger2(3));
        System.out.println("reverseMinHeap:");
        while (reverseMinHeap.size() != 0) {
            System.out.println(reverseMinHeap.poll().value);
        }

    }
}
