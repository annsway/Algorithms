package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsWithSizeKII {
    public static List<String> subSetsIIOfSizeK(String input, int k) {
        List<String> res = new ArrayList<>();
        // sanity check
        if (input == null || input.length() == 0 && k >= 1) {
            return res;
        }
        char[] array = input.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        DFS(array, 0, sb, res, k);
        return res;
    }
    private static void DFS(char[] array, int level, StringBuilder sb, List<String> res, int k) {
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        if (level == array.length) {
            return;
        }
        sb.append(array[level]);
        DFS(array, level + 1, sb, res, k);
        sb.deleteCharAt(sb.length() - 1);
        while (level + 1 < array.length && array[level] == array[level + 1]) {
            level++;
        }
        DFS(array, level + 1, sb, res, k);
    }

    public static void main(String[] args) {
        System.out.println(subSetsIIOfSizeK("abbbc", 2)); // 43 vs.127
    }
}
