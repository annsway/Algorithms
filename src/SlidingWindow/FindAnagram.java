package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return findAnagrams(p, s);
        }
        List<Integer> res = new ArrayList<>();
        int k = p.length();
        int[] count_p = new int[26];
        int[] count_s = new int[26];
        for (int i = 0; i < k; i++) {
            count_p[p.charAt(i) - 'a']++;
            count_s[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i + k <= s.length(); i++) {
            if (matches(count_p, count_s)) {
                res.add(i);
            }
            if (i + k == s.length()) {
                break;
            }
            count_s[s.charAt(i + k) - 'a']++;
            count_s[s.charAt(i) - 'a']--;
        }
        return res;
    }

    private boolean matches(int[] count_p, int[] count_s) {
        for (int i = 0; i < count_p.length; i++) {
            if (count_p[i] != count_s[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagram sol = new FindAnagram();
//        System.out.println(sol.findAnagrams("abab", "ab"));
//        System.out.println(sol.findAnagrams("baa", "aa"));
        System.out.println(sol.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }
}
