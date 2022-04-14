package Heap;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest sol = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(sol.add(3)); // 4
    }
}
