package Heap;

import java.util.*;

public class KsmallestUnsorted {
    public MyInteger[] kSmallest(int[] array, int k) {
        // Use this constructor in order to call heapify(): PriorityQueue(Collection<? extends E> c)
        List<MyInteger> firstK = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            firstK.add(new MyInteger(array[i]));
        }
        PriorityQueue<MyInteger> maxHeap = new PriorityQueue<>(firstK);

        for (int num : array) {
            MyInteger cur = new MyInteger(num);
           if (cur.value < maxHeap.peek().value) {
                maxHeap.poll();
                maxHeap.offer(cur);
            }
        }
        MyInteger[] res = new MyInteger[maxHeap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        KsmallestUnsorted sol = new KsmallestUnsorted();
        MyInteger[] res = sol.kSmallest(new int[]{1, 2, 6, 10, -4}, 2);
        for (MyInteger num : res) {
            System.out.println(num.value);
        }
    }
}
