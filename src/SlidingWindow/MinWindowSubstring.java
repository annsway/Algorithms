package SlidingWindow;

import Utility.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String source, String target) {
        if (source.length() == 0 || target.length() == 0 || source.length() < target.length()) {
            return "";
        }
        int m = target.length(), n = source.length();
        // targetCounter stores the count of each char in target
        Map<Character, Integer> targetCounter = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char key = target.charAt(i);
            targetCounter.put(key, targetCounter.getOrDefault(key, 0) + 1);
        }
        // subCounter stores the count of each char in the current substring
        Map<Character, Integer> subCounter = new HashMap<>();
        int matchedChar = 0;
        int j = 0;

        // save the output
        int start = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            while (j < n && matchedChar < targetCounter.size()) {
                char c = source.charAt(j);
                subCounter.put(c, subCounter.getOrDefault(c, 0) + 1);
                if (subCounter.get(c).equals(targetCounter.get(c))) {
                    matchedChar++; // increment matchedChar only if the char counts are *equal*
                }
                j++;
            }
            if (matchedChar == targetCounter.size()) {
                int curLen = (j - 1) - i + 1;
                // update len only if encountered a shorter substring
                if (minLen > curLen) {
                    minLen = curLen;
                    start = i;
                }
            }
            // remove the start of the window
            char sc = source.charAt(i);
            subCounter.put(sc, subCounter.getOrDefault(sc, 0) - 1);
            if (subCounter.get(sc).equals(targetCounter.getOrDefault(sc, 0) - 1)) {
                matchedChar--;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : source.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinWindowSubstring sol = new MinWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(sol.minWindow(s, t));
    }
}
