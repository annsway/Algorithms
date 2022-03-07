package Greedy;

public class BuyStockI {
    public static int maxProfit(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int globalMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num <= min) {
                min = num;
            } else if (num > min) {
                max = num;
                globalMax = Math.max(globalMax, max - min);
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6, 4, 8, 2, 7, 1, 3}));
    }
}
