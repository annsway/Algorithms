package DP;

public class LargestSubArraySum {
    public int largestSum(int[] array) {
        int[] M = new int[array.length]; // M[i] stands for the max subarray sum up to current index
        M[0] = array[0];
        int globalMax = M[0];
        for (int i = 1; i < array.length; i++) {
            M[i] = Math.max(M[i - 1] + array[i], array[i]);
            globalMax = Math.max(globalMax, M[i]);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LargestSubArraySum sol = new LargestSubArraySum();
        System.out.println(sol.largestSum(new int[]{2, -1, 4, -2, 1})); // Expected: 5

    }
}
