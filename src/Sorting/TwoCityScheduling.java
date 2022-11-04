package Sorting;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0]));
        // sort by the profit gained from going to city A and not going to city B
        // profit = B - A
        int minCost = 0;
        int n = costs.length;
        for (int i = 0; i < n / 2; i++) {
            minCost += costs[i][0];
        }
        for (int i = n / 2; i < n; i++) {
            minCost += costs[i][1];
        }
        return minCost;
    }

    public static void main(String[] args) {
        TwoCityScheduling sol = new TwoCityScheduling();
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(sol.twoCitySchedCost(costs));
    }
}
