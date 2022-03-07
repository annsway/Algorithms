package String;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s != null && t != null && (s.length() != t.length())) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] count2 = new int[26];
        for (char c : t.toCharArray()) {
            count2[c - 'a']++;
        }
        return Arrays.equals(count,count2);
    }

    public static void main(String[] args) {
        IsAnagram sol = new IsAnagram();
        System.out.println(sol.isAnagram("anagram","nagaram"));
    }
}
