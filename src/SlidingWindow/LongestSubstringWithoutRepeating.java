package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> slidingWindow = new HashSet<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character cur = s.charAt(right);
            while (slidingWindow.contains(cur)) {
                slidingWindow.remove(s.charAt(left));
                left++;
            }
            slidingWindow.add(cur);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
//        System.out.println(sol.lengthOfLongestSubstring("dvdf"));
        System.out.println(sol.lengthOfLongestSubstring("abcdefg"));
    }
}
