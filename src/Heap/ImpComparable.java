package Heap;

import java.util.PriorityQueue;

public class ImpComparable {
    public static void main(String[] args) {
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>();
        maxHeap.offer(new Cell(1, 2));
        maxHeap.offer(new Cell(-1, 5));
        maxHeap.offer(new Cell(4, 6));
        // print maxHeap from to top down
        while (maxHeap.size() != 0) {
            Cell cur = maxHeap.poll();
            System.out.println("(" + cur.x + ", " + cur.y + "), value = " + cur.value);
        }
    }
}

class Cell implements Comparable<Cell> {
    int x;
    int y;
    int value;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.value = x * y;
    }

    @Override
    public int compareTo(Cell o) {
        if (this.value == o.value) {
            return 0;
        }
        return this.value > o.value ? -1 : 1; // max heap
    }
}