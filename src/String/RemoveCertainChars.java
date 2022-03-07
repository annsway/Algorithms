package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveCertainChars {
    public String remove(String input, String t) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int end = 0;
        while (end < input.length()) {
            if (!set.contains(input.charAt(end))) {
                sb.append(input.charAt(end));
            }
            end++;
        }
        return sb.toString();
    }

    public String remove2(String input, String t) {
        char[] res = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int slow = 0; // [0, slow): result; [slow, fast): explored; [fast, n - 1]: unexplored
        for (int fast = 0; fast < res.length; fast++) {
            if (!set.contains(res[fast])) {
                res[slow] = res[fast];
                slow++;
            }
        }
        return new String(res, 0, slow);
    }

    public static void main(String[] args) {
        RemoveCertainChars sol = new RemoveCertainChars();
        System.out.println(sol.remove2("abc", "ab"));
    }
}
