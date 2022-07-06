package Greedy;

import java.util.HashMap;
import java.util.Map;

public class DeliverBoxes {
    public int minRounds(int[] boxes) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int wt : boxes) {
            freqMap.put(wt, freqMap.getOrDefault(wt, 0) + 1);
        }
        int min = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int wt = entry.getKey();
            int freq = entry.getValue();

            if (freq < 2) {
                return -1; // cannot deliver weight less than 2
            } else if (freq % 3 == 0) {
                min += freq / 3;
                freqMap.put(wt, 0);
            } else if (freq % 2 == 0) {
                min += freq / 2;
                freqMap.put(wt, 0);
            } else {
                int remFreq = freq % 3;
                if (remFreq % 2 == 0) {
                    min += 2;
                } else {
                    return -1;
                }
            }

        }
        return min;
    }
    public static void main(String[] args) {
//        int[] boxes = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4}; // 4

        int[] boxes = {2, 2, 3}; // -1
        DeliverBoxes sol = new DeliverBoxes();
        System.out.println(sol.minRounds(boxes));
    }
}
