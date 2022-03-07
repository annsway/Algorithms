package Heap;

import java.util.PriorityQueue;

public class ReverseNaturalOrder {
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

        // reversed order for Integer class:
        PriorityQueue<MyInteger> maxHeap = new PriorityQueue<>();
        maxHeap.offer(new MyInteger(99));
        maxHeap.offer(new MyInteger(-1));
        maxHeap.offer(new MyInteger(3));
        System.out.println("maxHeap:");
        while (maxHeap.size() != 0) {
            System.out.println(maxHeap.poll().value);
        }
    }
}

class MyInteger implements Comparable<MyInteger> {
    int value;

    MyInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyInteger another) { // the parameter must be the exact same as the generic <E> of Comparable
        return Integer.valueOf(another.value).compareTo(this.value); // max heap
    }
}
