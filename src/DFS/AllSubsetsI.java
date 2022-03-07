package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    public static List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        // corner case
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(array, 0, sb, res);
        return res;
    }

    private static void dfs(char[] array, int level, StringBuilder sb, List<String> res) {
        // base case
        if (level == array.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(array[level]);
        dfs(array, level + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
//        dfs(array, level + 1, sb, res);
    }

    public static void main(String[] args) {
        System.out.println(subSets("abc"));
    }
}
