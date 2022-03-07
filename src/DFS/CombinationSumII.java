package DFS;

import java.util.*;

public class CombinationSumII {
    public static int count = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, cur, candidates, target, 0);
        return new ArrayList<>(res);
    }

    private void dfs(Set<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                count++;
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            cur.add(candidates[i]);
            dfs(res, cur, candidates, target - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        CombinationSumII sol = new CombinationSumII();
//        int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(sol.combinationSum2(candidates, 30));
        System.out.println(count); //2535
    }
}
