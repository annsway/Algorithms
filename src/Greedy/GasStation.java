package Greedy;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0;
        int totalSurplus = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            surplus = gas[i] + surplus - cost[i];
            if (surplus < 0) {
                // reset
                surplus = 0;
                startIndex = i + 1; //// restart from i + 1, otherwise 可能陷入无限循环
            }
            totalSurplus = totalSurplus + gas[i] - cost[i];
        }
        return totalSurplus < 0 ? -1 : startIndex;
    }

    public static void main(String[] args) {
        System.out.println(GasStation.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // expected: 3
        System.out.println(GasStation.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // expected: -1
    }
}
