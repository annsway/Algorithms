package DFS;

import java.util.*;

public class Permutation2withDuplicates {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(input.toCharArray(), 0, sb, res);
        return res;
    }
    private void dfs(char[] array, int index, StringBuilder sb, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            dfs(array, index + 1, sb, res);
            swap(array, i, index);
        }
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Permutation2withDuplicates sol = new Permutation2withDuplicates();
        System.out.println(sol.permutations("abb"));
    }
}
