package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarrayPairSum {
    static int subarrayPairSum(int[] a, int m, int k) {
        int left = 0, right = m, res = 0, n = a.length;
        while (right < n) {
            Set<Integer> set = new HashSet<>();
            for (int i = left; i < right; i++) {
                if (set.contains(a[i])) {
                    res++;
                    break;
                }
                set.add(k - a[i]);
            }
            left++;
            right++;
        }
        return res;
    }

    static int subarrayPairSum2(int[] a, int m, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int n = a.length, start = 0, end = 0, res = 0;
        while (end < n) {
            while (end - start + 1 > m) {
                int cur = a[start];
                freqMap.put(cur, freqMap.getOrDefault(cur, 0) - 1);
                start++;
            }
            int rem = k - a[end];
            res += freqMap.getOrDefault(rem, 0);
            System.out.println(" start: " + start + " end: " + end + " a[end]: " + a[end] + " rem: " + rem + " freqMap.get(rem): " + freqMap.getOrDefault(rem, 0));
            freqMap.put(a[end], freqMap.getOrDefault(a[end], 0) + 1);
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayPairSum.subarrayPairSum(new int[]{2, 4, 7, 5, 3, 5, 8, 5, 1, 7}, 4, 10)); // expected: 5
    }

}
