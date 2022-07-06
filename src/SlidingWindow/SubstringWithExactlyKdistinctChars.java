package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithExactlyKdistinctChars {
    public int countAtLeastKDistinct(String s, int k) {
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public int countSubstring(String s, int k) {
        return countAtLeastKDistinct(s, k) - countAtLeastKDistinct(s, k - 1);
    }

    public static void main(String[] args) {
        SubstringWithExactlyKdistinctChars sol = new SubstringWithExactlyKdistinctChars();
        String s = "pqpqs";
        System.out.println(sol.countSubstring(s, 2));
    }
}
