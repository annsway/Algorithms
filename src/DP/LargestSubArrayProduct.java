package DP;

public class LargestSubArrayProduct {
    public double largestProduct(double[] array) {
        int n = array.length;
        double[] max = new double[n];
        double[] min = new double[n];
        max[0] = array[0];
        min[0] = array[0];
        double globalMax = max[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(Math.min(max[i - 1] * array[i], min[i - 1] * array[i]), array[i]);
            max[i] = Math.max(Math.max(max[i - 1] * array[i], min[i - 1] * array[i]), array[i]);
            globalMax = Math.max(globalMax, max[i]);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LargestSubArrayProduct sol = new LargestSubArrayProduct();
        System.out.println(sol.largestProduct(new double[]{2.0, -0.1, 4, -2, -1.5})); // expected: 12
    }
}
