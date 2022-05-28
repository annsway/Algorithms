package DP;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            int one = dp[i - 1] + cost[i - 1];
            int two = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(one, two);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs sol = new MinCostClimbingStairs();
        int[] nums = {1,100,1,1,1,100,1,1,100,1}; // 6
        System.out.println(sol.minCostClimbingStairs(nums));
    }
}
