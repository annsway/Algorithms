package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtracking(res, cur, n, k, 1);
        return new ArrayList<>(res);
    }
    private void backtracking(List<List<Integer>> res, List<Integer> cur, int n, int k, int index) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (cur.size() == 0 || i > cur.get(cur.size() - 1)) {
                cur.add(i);
                backtracking(res, cur, n, k, index + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations sol = new Combinations();
        System.out.println(sol.combine(4, 2));
    }
}
