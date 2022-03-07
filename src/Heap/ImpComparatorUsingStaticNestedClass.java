package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ImpComparatorUsingStaticNestedClass {

    public static void main(String[] args) {
        PriorityQueue<MyInteger2> minHeap = new PriorityQueue<>(new MyInteger2.MyComparator());
        minHeap.offer(new MyInteger2(-1));
        minHeap.offer(new MyInteger2(9));
        minHeap.offer(new MyInteger2(3));
        while (minHeap.size() != 0) {
            System.out.println("min heap: " + minHeap.poll().value);
        }
    }
}

class MyInteger2 {
    int value;
    MyInteger2 (int value) {
        this.value = value;
    }
    static class MyComparator implements Comparator<MyInteger2> {
        @Override
        public int compare(MyInteger2 o1, MyInteger2 o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return o1.value < o2.value ? -1 : 1; // min heap
        }
    }
}