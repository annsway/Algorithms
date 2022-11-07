package SlidingWindow;

public class MaxStockRevenue {
    public static int maxStockRevenue(int[] prices, int[] algo, int k) {
        int orgRev = 0, n = prices.length;
        for (int i = 0; i < n; i++) {
            if (algo[i] > 0) {
                orgRev += prices[i];
            } else {
                orgRev -= prices[i];
            }
        }
        System.out.println("orgRev: " + orgRev);
        int slow = 0, fast = 0, maxRevIncrease = 0;
        while (fast < n) {
            while (fast - slow + 1 > k) {
                if (algo[slow] == 0) {
                    maxRevIncrease -= prices[slow]; // flip it back to 0
                }
                slow++;
            }
            if (algo[fast] == 0) {
                maxRevIncrease += prices[fast];
            }
            fast++;
        }
        return orgRev + maxRevIncrease * 2;
    }
    /**
     i =  0  1  2  3  4  5  6
     prices = {2, 4, 1, 5, 2, 6, 7}
     algo = {0, 1, 0, 0, 1, 0, 0}
     k = 4
     Expected Output: 21

     We can maximize the total revenue by making the last k = 4 orders 1 (sell),
     thus making algo = [0, 1, 0, 1, 1, 1, 1]. The total revenue will become -2 + 4 - 1 + 5 + 2 + 6 + 7 = 21.

     0 means buy and 1 means sell.
     */

    public static void main(String[] args) {
        int[] prices = {2, 4, 1, 5, 2, 6, 7};
        int[] algo = {0, 1, 0, 0, 1, 0, 0};
        System.out.println(MaxStockRevenue.maxStockRevenue(prices, algo, 4)); // expected: 21
    }

}
