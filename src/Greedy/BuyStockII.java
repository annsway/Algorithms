package Greedy;

public class BuyStockII {
    public static int maxProfit(int[] array) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
            } else if (array[i] > min && (i == array.length - 1 && array[i - 1] <= array[i] ||
                    i + 1 < array.length && array[i + 1] < array[i])) {
                profit = profit + (array[i] - min);
                // reset min
                min = Integer.MAX_VALUE;
            }
        }
        return profit;
    }

// TC: O(n)
// SC: O(1)

    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{3, 4, 1, 2, 7, 6})); // 7
//        System.out.println(maxProfit(new int[]{3, 4, 1, 2, 7})); // 7
//        System.out.println(maxProfit(new int[]{5, 1, 2, 3, 7, 2, 5, 1, 3})); // 11
        System.out.println(maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9})); // 25
    }
}
