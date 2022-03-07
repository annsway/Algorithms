package DFS;

import java.util.*;

public class AllSubsetsII {
    public static List<String> subSets(String input) {
        List<String> res = new ArrayList<>();
        // sanity check
        if (input == null) {
            return res;
        }
        char[] array = input.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        DFS(array, 0, sb, res);
        return res;
    }
    private static void DFS(char[] array, int level, StringBuilder sb, List<String> res) {
        if (level == array.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(array[level]);
        DFS(array, level + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        while (level + 1 < array.length && array[level] == array[level + 1]) {
            level++;
        }
        DFS(array, level + 1, sb, res);
    }

    public static void main(String[] args) {
        System.out.println(subSets("aabb"));
    }
}
