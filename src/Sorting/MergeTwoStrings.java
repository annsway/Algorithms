package Sorting;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoStrings {
    public static String merge (String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char key = s2.charAt(i);
            freqMap2.put(key, freqMap2.getOrDefault(key, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            char a = s1.charAt(i), b = s2.charAt(j);
            if (freqMap.get(a) < freqMap2.get(b)) {
                sb.append(a);
                i++;
            } else if (freqMap.get(a) > freqMap2.get(b)) {
                sb.append(b);
                j++;
            } else {
                if (a < b) {
                    sb.append(a);
                    i++;
                } else if (a > b) {
                    sb.append(b);
                    j++;
                } else {
                    sb.append(a);
                    i++;
                }
            }
        }
        // in case any chars left
        if (i < s1.length()) {
            sb.append(s1.substring(i));
        }
        if (j < s2.length()) {
            sb.append(s2.substring(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "dce", s2 = "cccbd";
        System.out.println(MergeTwoStrings.merge(s1, s2)); // dcecccbd

        String s3 = "super", s4 = "tower";
        System.out.println(MergeTwoStrings.merge(s3, s4)); // stouperwer

        String s5 = "", s6 = "a";
        System.out.println(MergeTwoStrings.merge(s5, s6)); // a

    }

}
