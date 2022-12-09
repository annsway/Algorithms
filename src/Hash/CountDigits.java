package Hash;

import java.util.*;

public class CountDigits {
    public static int[] solution(int[] a) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int max = 0;
        for (int num : a) {
            while (num > 0) {
                int d = num % 10;
                freqMap.put(d, freqMap.getOrDefault(d, 0) + 1);
                max = Math.max(max, freqMap.get(d));
                num /= 10;
            }
        }
        System.out.println("max: " + max);
        List<Integer> list = new ArrayList<>();
        for (Integer key : freqMap.keySet()) {
            if (freqMap.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{20, 0, 3, 50, 38, 41};
        System.out.println(Arrays.toString(CountDigits.solution(a)));
    }
}
