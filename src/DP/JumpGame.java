package DP;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        // dp[i] represents whether or not we can jump from the CURRENT position i to the END of the array
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int curMax = nums[i];
            for (int j = i + 1; j <= i + curMax && j < n; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJump(new int[]{2, 3, 1, 1, 4})); // expected: true
    }
}
