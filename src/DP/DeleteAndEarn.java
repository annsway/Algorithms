package DP;

import java.util.HashMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNumber = 0;

        // Precompute how many map we gain from taking an element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        // Declare our array along with base cases
        int[] dp = new int[maxNumber + 1];
        dp[1] = map.getOrDefault(1, 0);

        for (int num = 2; num < dp.length; num++) {
            // Apply recurrence relation
            int gain = map.getOrDefault(num, 0);
            dp[num] = Math.max(dp[num - 1], dp[num - 2] + gain);
        }

        return dp[maxNumber];
    }

    public static void main(String[] args) {
        DeleteAndEarn sol = new DeleteAndEarn();
        int[] nums = {2, 3, 3, 3};
        System.out.println(sol.deleteAndEarn(nums));
    }
}
