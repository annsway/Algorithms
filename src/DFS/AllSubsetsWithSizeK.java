package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsWithSizeK {
    private static int count = 0;
    public static List<String> subSetsOfSizeK(String input, int k) {
        List<String> res = new ArrayList<>();
        if (input == null || input.length() == 0 && k >= 1) {
            return res;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        DFS(array, 0, sb, res, k);
        return res;
    }
    private static void DFS2(char[] array, int level, StringBuilder sb, List<String> res, int k) {
        count++; // test
        if (level == array.length) {
            if (sb.length() == k) {
                res.add(sb.toString());
            }
            return;
        }
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        sb.append(array[level]);
        DFS(array, level + 1, sb, res, k);
        sb.deleteCharAt(sb.length() - 1);
        DFS(array, level + 1, sb, res, k);
    }
    private static void DFS1(char[] array, int level, StringBuilder sb, List<String> res, int k) {
        count++; // test
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        if (level == array.length) {
            return;
        }
        DFS(array, level + 1, sb, res, k);
        sb.append(array[level]);
        DFS(array, level + 1, sb, res, k);
        sb.deleteCharAt(sb.length() - 1);
    }
    // test for k-nary tree DFS
    private static void DFS(char[] array, int level, StringBuilder sb, List<String> res, int k) {
        count++;
        if (sb.length() == k) {
            res.add(sb.toString());
            return;
        }
        if (level == array.length) {
            return;
        }
        for (int i = level; i < array.length; i++) {
            sb.append(array[level]);
            DFS(array, level + 1, sb, res,  k);
            sb.deleteCharAt(sb.length() - 1);
            DFS(array, level + 1, sb, res,  k);
        }
    }
    public static void main(String[] args) {
//        System.out.println(subSetsOfSizeK("abcefg", 2)); // 43 vs.127
                System.out.println(subSetsOfSizeK("tebh", 4)); // 31 vs. 633
        System.out.println("# of recursive calls: " + count);
    }
}
