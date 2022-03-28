package Heap;

import java.util.*;

public class KsmallestUnsorted {
    public int[] kSmallest(int[] array, int k) {
        // corner case
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        for (int num : array) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num); // 1. O(klogk)
            } else if (num < maxHeap.peek()) {
                maxHeap.poll(); // 2. O((n-k)logk) -- percolateUp
                maxHeap.offer(num); // 3. O((n-k)logk) -- percolateDown
            }
        }
        int[] res = new int[maxHeap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = maxHeap.poll(); // 4. O(klogk)
        }
        return res;
    }
//    public MyInteger[] kSmallest(int[] array, int k) {
//        // Use this constructor in order to call heapify(): PriorityQueue(Collection<? extends E> c)
//        List<MyInteger> firstK = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            firstK.add(new MyInteger(array[i]));
//        }
//        PriorityQueue<MyInteger> maxHeap = new PriorityQueue<>(firstK);
//
//        for (int num : array) {
//            MyInteger cur = new MyInteger(num);
//           if (cur.value < maxHeap.peek().value) {
//                maxHeap.poll();
//                maxHeap.offer(cur);
//            }
//        }
//        MyInteger[] res = new MyInteger[maxHeap.size()];
//        for (int i = res.length - 1; i >= 0; i--) {
//            res[i] = maxHeap.poll();
//        }
//        return res;
//    }

    public static void main(String[] args) {
        KsmallestUnsorted sol = new KsmallestUnsorted();
//        MyInteger[] res = sol.kSmallest(new int[]{1, 2, 6, 10, -4}, 2);
        sol.kSmallest(new int[]{1, 2, 6, 10, -4}, 2);
//        for (MyInteger num : res) {
//            System.out.println(num.value);
//        }
    }
}
