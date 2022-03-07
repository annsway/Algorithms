package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(res, cur, candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(res, cur, candidates, i, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(sol.combinationSum(candidates, 7));
    }
}
