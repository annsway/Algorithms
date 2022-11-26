package Hash;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] array = new int[26];
            for (char c : s.toCharArray()) {
                array[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(array[i]).append("#");
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
            // System.out.println(key);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagram sol = new GroupAnagram();
//        System.out.println(sol.groupAnagrams(new String[]{"ac","c"}));
        System.out.println(sol.groupAnagrams(new String[]{"bddd","bbbc"}));

    }
}
