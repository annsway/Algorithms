package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ImpComparatorUsingTopLevelClass {
    public static void main(String[] args) {
        PriorityQueue<MyInteger> minHeap = new PriorityQueue<>(new MyComparator());
        minHeap.offer(new MyInteger(-1));
        minHeap.offer(new MyInteger(9));
        minHeap.offer(new MyInteger(3));
        while (minHeap.size() != 0) {
            System.out.println("max heap: " + minHeap.poll().value);
        }
    }
}

// top-level class
// 注意：这里调用的是同包下的 MyInteger class. => 复习：default modifier (no modifier): 同包可见
class MyComparator implements Comparator<MyInteger> {
    @Override
    public int compare(MyInteger o1, MyInteger o2) {
        if (o1.equals(o2)) {
            return 0; 
        }
        return o1.value < o2.value ? -1 : 1; // min heap
    }
}