package Heap;

import java.util.*;

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        // Hash + Heap
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : combo) {
            Integer oldValue = countMap.get(s);
            if (oldValue == null) {
                countMap.put(s, 1);
            } else {
                countMap.put(s, ++oldValue);
            }
        }
//        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if (o1.equals(o2)) {
//                    return 0;
//                }
//                return o1.getValue() < o2.getValue() ? -1 : 1;
//            }
//        });
        // Use lambda expression to implement PQ
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() < o2.getValue()  ? -1 : o1.getValue() > o2.getValue() ? 1 : 0);

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] res = new String[minHeap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords sol = new TopKFrequentWords();
        System.out.println(Arrays.toString(sol.topKFrequent(new String[]{"d", "a", "c", "b", "d", "a", "b", "b", "a", "d", "d", "a", "d"}, 4)));
        // Expected: [["d", "a", "b", "c"]]
    }
}
