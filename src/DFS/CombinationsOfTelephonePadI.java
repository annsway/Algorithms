package DFS;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsOfTelephonePadI {
    String[] pad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public String[] combinations(int number) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, 0, Integer.toString(number).toCharArray(), res);
        return res.toArray(new String[0]);
    }
    private void dfs(StringBuilder sb, int index, char[] number, List<String> res) {
        // base case
        if (index == number.length) {
            res.add(sb.toString());
            return;
        }
        // number: {'2', '3' } is a char[], so we need to convert each char to int
        char[] chars = pad[number[index] - '0'].toCharArray();
        if (chars.length == 0) {
            // 对于 {0:"", 1:""}, 它们没有对应的字母，但是我们依然需要往下走一层，来达到 base case, 否则 base case 永远无法达到，会返回空集
            // test case: 231
            dfs(sb, index + 1, number, res);
        } else {
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
                dfs(sb, index + 1, number, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationsOfTelephonePadI sol = new CombinationsOfTelephonePadI();
//        System.out.println(Arrays.toString(sol.combinations(23)));
        System.out.println(Arrays.toString(sol.combinations(231)));
//        System.out.println(Arrays.toString(sol.combinations(23)));
//        System.out.println(Arrays.toString(sol.combinations(23)));

    }
}
