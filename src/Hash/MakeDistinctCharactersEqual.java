package Hash;

import java.util.HashMap;
import java.util.Map;

public class MakeDistinctCharactersEqual {
    public static boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char[] a1 = word1.toCharArray();
        char[] a2 = word2.toCharArray();

        for (char c : a1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : a2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if (map1.size() == map2.size()) {
            return true;
        }

        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                map1.put(a1[i], map1.getOrDefault(a1[i], 0) - 1);
                map1.put(a2[j], map1.getOrDefault(a2[j], 0) + 1);

                map2.put(a2[j], map2.getOrDefault(a2[j], 0) - 1);
                map2.put(a1[i], map2.getOrDefault(a1[i], 0) + 1);

                if (map1.get(a1[i]) == 0) {
                    map1.remove(a1[i]);
                }
                if (map2.get(a2[j]) == 0) {
                    map2.remove(a2[j]);
                }
                // check
                if (map1.size() == map2.size()) {
                    return true;
                } else {
                    // put back
                    map1.put(a1[i], map1.getOrDefault(a1[i], 0) + 1);
                    map1.put(a2[j], map1.getOrDefault(a2[j], 0) - 1);

                    map2.put(a2[j], map2.getOrDefault(a2[j], 0) + 1);
                    map2.put(a1[i], map2.getOrDefault(a1[i], 0) - 1);

                    if (map1.get(a2[j]) == 0) {
                        map1.remove(a2[j]);
                    }
                    if (map2.get(a1[i]) == 0) {
                        map2.remove(a1[i]);
                    }
                }

            }
        }
        return false;

    }

    public static void main(String[] args) {
        String a = "a";
        String b = "bb";
        System.out.println(MakeDistinctCharactersEqual.isItPossible(a, b));
    }
}
