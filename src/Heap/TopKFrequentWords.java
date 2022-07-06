package Heap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(List<String> words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (o1, o2) -> o1.getValue().equals(o2.getValue()) ?
                        o2.getKey().compareTo(o1.getKey()) :
                        o1.getValue() - o2.getValue());

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
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
        String s = "Jimmy has an apple, it is on the table, he like it";
        String[] excludeWords = {"a", "an", "the"};
        List<String> words = sol.tokenize(s, excludeWords);
        System.out.println(sol.topKFrequent(words, 1));
    }
/*** Example
    Input: s = “Jimmy has an apple, it is on the table, he like it”
    excludeWords = [“a”,“an”,“the”]
    Output:“it”     */
    private List<String> tokenize(String s, String[] exclude) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(exclude));

        int slow = 0, fast = 0;

        while (slow < s.length()) {
            while (fast < s.length() && Character.isLetter(s.charAt(fast))) {
                fast++;
            }
            String str = s.substring(slow, fast);
            if (!"".equals(str) && !set.contains(str)) {
                list.add(str);
            }
            fast++;
            slow = fast;
        }
        return list;
    }
}
