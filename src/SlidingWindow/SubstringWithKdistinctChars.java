package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWithKdistinctChars {
    public List<String> getSubstringsWithKdistinct(String s, int k) {
        Set<String> res = new HashSet<>();
        Set<Character> window = new HashSet<>(); // stores the chars of substring with distinct k chars
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            while (window.contains(s.charAt(end))) {
                window.remove(s.charAt(start++));
            }
            window.add(s.charAt(end));
            if (window.size() == k) {
                res.add(s.substring(start, end + 1));
                window.remove(s.charAt(start++));
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        SubstringWithKdistinctChars sol = new SubstringWithKdistinctChars();
//        System.out.println(sol.getSubstringsWithKdistinct("abacab", 3));
        System.out.println(sol.getSubstringsWithKdistinct("awaglknagawunagwkwagl", 4));
//        Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
    }
}
