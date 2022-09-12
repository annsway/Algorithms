package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringsSizeKwithKdistinctChars {
    public List<String> getStrings(String s, int k) {
        Set<String> res = new HashSet<>();
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, n = s.length();
        while (right < n) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            if (window.size() == k) {
                res.add(s.substring(left, right + 1));
                window.remove(s.charAt(left++));
            }
            right++;
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        SubstringsSizeKwithKdistinctChars sol = new SubstringsSizeKwithKdistinctChars();
        String s = "awaglknagawunagwkwagl"; int k = 4;
//        String s = "abcabc"; int k = 3;
        System.out.println(sol.getStrings(s, k));
    }
}
