package SlidingWindow;

import java.util.*;

public class SubstringWithKminus1DistinctChars {

    public List<String> getKminus1Distinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = -1, repeatChar = -1;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = repeatChar;
                repeatChar = map.get(c);
            }
            map.put(c, i);
            if (left <= i - k && i - k < repeatChar) {
                // 起点在左端点和重复字符之间，
                // 小于left则会有多个重复字符，
                // 大于等于repeatChar则会没有重复字符
                res.add(s.substring(i - k + 1, i + 1));
            }
        }
        return res;

    }

    public static void main(String[] args) {
        SubstringWithKminus1DistinctChars sol = new SubstringWithKminus1DistinctChars();
        System.out.println(sol.getKminus1Distinct("bawaglk", 4)); // expected: "awag"
    }
}
