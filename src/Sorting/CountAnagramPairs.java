package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountAnagramPairs {
    public static int solution(int[] a) {
        int count = 0;
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            // sort
            char[] word = String.valueOf(a[i]).toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        // count
        for (String key : freqMap.keySet()) {
            int n = freqMap.get(key);
            count += n * (n - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] arr1 = {25, 35, 872, 228, 53, 278, 872}; // 4
//        System.out.println(CountAnagramPairs.solution(arr1));

        int[] arr2 = {2, 20}; // 0
        System.out.println(CountAnagramPairs.solution(arr2));
    }
}
