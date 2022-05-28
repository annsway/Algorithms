package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> slidingWindow = new HashSet<>();
//        int max = 0;
//        int left = 0;
//        for (int right = 0; right < s.length(); right++) {
//            Character cur = s.charAt(right);
//            while (slidingWindow.contains(cur)) {
//                slidingWindow.remove(s.charAt(left));
//                left++;
//            }
//            slidingWindow.add(cur);
//            max = Math.max(max, right - left + 1);
//        }
//        return max;
//    }

    public int lengthOfLongestSubstring(String s) {
        int globalMax = 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(i - count));
                count--;
            }
            set.add(c);
            count++;
            globalMax = Math.max(globalMax, count);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
//        System.out.println(sol.lengthOfLongestSubstring("dvdf"));
        System.out.println(sol.lengthOfLongestSubstring("abcdefg"));
    }
}
