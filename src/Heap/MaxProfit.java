package Heap;

import java.util.PriorityQueue;

/**
 * Input
 * The input to the function's method consists of these arguments:
 * numSuppliers, and integer representing the number of suppliers;
 * inventory, a list of long integers representing the value of the item at a given supplier;
 * order, a long integer representing the number of items to be ordered
 *
 * Output
 * Return a long integer representing the highest profit that can be generated for the given product.
 *
 * Example
 * Input:
 * numSuppliers = 2
 * inventory = [3,5]
 * order = 6
 * Output: 19
 *
 * Explanation:
 * There are two suppliers, one with inventory 3 and the other with inventory 5, and 6 items were ordered.
 * The maximum profit is made by selling 1 for 5, 1 for 4, and 2 at 3 and 2 at 2 units profit. The two suppliers are left with a unit of product each.
 * The maximum profit generated is 5 + 4 + 2 * 3 + 2 * 2 = 19
 * */
public class MaxProfit {
    public int maxProfit(int numSuppliers, int[] inventory, int numOrders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : inventory) {
            maxHeap.offer(i);
        }
        int profit = 0;
        while (numOrders != 0 && !maxHeap.isEmpty()) {
            int maxPrice = maxHeap.poll();
            profit += maxPrice;
            maxPrice--;
            numOrders--;
            if (maxPrice != 0) {
                maxHeap.offer(maxPrice);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit sol = new MaxProfit();
        System.out.println(sol.maxProfit(2, new int[]{3, 5}, 6));
    }
}
