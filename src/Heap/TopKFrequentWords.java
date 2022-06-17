package Heap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() - o2.getValue());

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (minHeap.isEmpty() || minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        String[] array = new String[minHeap.size()];
        int index = array.length - 1;

        while (!minHeap.isEmpty()) {
            array[index--] = minHeap.poll().getKey();
        }

        return Arrays.asList(array);
    }

    public static void main(String[] args) {
        TopKFrequentWords sol = new TopKFrequentWords();
        String[] input = {"i","love","leetcode","i","love","coding"};
        System.out.println(sol.topKFrequent(input, 1));
        // Expected: [["d", "a", "b", "c"]]
    }
}
