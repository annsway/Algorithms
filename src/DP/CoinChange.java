package DP;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // dp[i] stands for the min number of coins needed to make up amount i

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (i - coins[k] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }

        return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int[] coins = {1,2,5};
        System.out.println(sol.coinChange(coins, 11));
    }
}
