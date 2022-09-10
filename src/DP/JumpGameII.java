package DP;

import java.util.Arrays;

public class JumpGameII {
    public int minJump(int[] array) {
        int n = array.length;
        int[] dp = new int[n];
        // dp[i] represents the min steps from current position i to reach to the end of the array
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int curMax = array[i]; // the max distance one can jump from current position i
            for (int j = i + 1; j <= i + curMax && j < n; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();
        System.out.println(sol.minJump(new int[]{3, 3, 1, 0, 4})); // 2
//        System.out.println(sol.minJump(new int[]{2, 1, 1, 0, 2})); // -1

    }
}
