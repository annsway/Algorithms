package DP;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // dp[i] represents the number of combinations that make up amount i
        dp[0] = 1;
         for (int coin : coins) {
           for (int x = coin; x <= amount; x++) {
             dp[x] += dp[x - coin];
           }
         }
        // Below is wrong
//        for (int x = 1; x <= amount; x++) {
//            for (int coin : coins) {
//                if (x - coin >= 0) {
//                    dp[x] += dp[x - coin];
//                }
//            }
//        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        CoinChangeII sol = new CoinChangeII();
        int[] coins = {1,2,5};
        System.out.println(sol.change(5, coins)); // 4
    }
}
