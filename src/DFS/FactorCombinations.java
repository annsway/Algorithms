package DFS;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(target, cur, res);
        return res;
    }
    private void dfs(int target,  List<Integer> cur, List<List<Integer>> res) {
        if (target == 1) {
            if (cur.size() > 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = 2; i <= target; i++) {
            if (target % i == 0 && (cur.isEmpty() || i >= cur.get(cur.size() - 1))) {
                cur.add(i);
                dfs(target / i, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations sol = new FactorCombinations();
        System.out.println(sol.combinations(6));
    }
}
