package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class SubstringAtLeastKDistinctChars {
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        long res = 0;
        int n = s.length();
        int end = 0;
        int distCount = 0;
        Map<Character, Integer> counter = new HashMap<>();
        for (int start = 0; start < n; start++) {
            while (end < n && distCount < k) {
                char c = s.charAt(end);
                counter.put(c, counter.getOrDefault(c, 0) + 1);
                if (counter.get(c) == 1) {
                    distCount++;
                }
                end++;
            }
            if (distCount == k) {
                res += (n - 1) - (end - 1) + 1;
                /**

                 0 1 2 3  n = 4
                 a b c d
                 ^ ^
                 */
            }
            // remove start element
            char c = s.charAt(start);
            counter.put(c, counter.get(c) - 1);
            if (counter.get(c) == 0) {
                distCount--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringAtLeastKDistinctChars sol = new SubstringAtLeastKDistinctChars();
        System.out.println(sol.kDistinctCharacters("abcd", 3));
    }
}
