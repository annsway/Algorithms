package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public static List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(coins, target, 0, cur, res);
        return res;
    }
    private static void dfs(int[] coins, int remaining, int level, List<Integer> cur, List<List<Integer>> res) {
        // base case
        if (level == coins.length - 1) {
            if (remaining % coins[level] == 0) {
                cur.add(remaining / coins[level]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        for (int times = 0; times <= remaining / coins[level]; times++) {
            cur.add(times);
            dfs(coins, remaining - coins[level] * times, level + 1, cur, res); // method 3
            cur.remove(cur.size() - 1);
        }
    }
//    public List<List<Integer>> combinations(int target, int[] coins) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> ans = new ArrayList<>();
//        dfs(target, coins, 0, ans, res);
//        return res;
//    }
//
//    private void dfs(int remainder, int[] coins, int index, List<Integer> ans, List<List<Integer>> res) {
//        // base case
//        if (index == coins.length - 1) { // * to reduce the number of branches
//            if (remainder % coins[index] == 0) { // this will check if the very last coin can meet the criteria without calling dfs() again
//                ans.add(remainder / coins[index]);
//                res.add(new ArrayList<>(ans));
//                ans.remove(ans.size() - 1);
//            }
//            return;
//        }
//        for (int num = 0; num <= remainder / coins[num]; num++) {
//            ans.add(num);
//            dfs(remainder - num * coins[num], coins, index + 1, ans, res);
//            ans.remove(ans.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        CombinationsOfCoins sol = new CombinationsOfCoins();
        System.out.println(sol.combinations(10, new int[]{5, 2, 1}));
    }
}
