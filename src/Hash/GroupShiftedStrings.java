package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : input) {
            String key = helper(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String helper(String s) {
        int dis = s.charAt(0) - 'a';

        char[] carr = new char[s.length()];
        carr[0] = 'a';

        for (int i = 1; i < s.length(); i++) {
            char c = (char)(s.charAt(i) - dis);
            if (c < 'a') {
                c += 26;
            }
            carr[i] = c;
        }
        return new String(carr);
    }

    public static void main(String[] args) {
        GroupShiftedStrings sol = new GroupShiftedStrings();
        String[] input = {"zp"};
        System.out.println(sol.groupStrings(input));
    }
}
