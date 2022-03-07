package PrefixSum;

public class RandomPickWithWeight {
    int[] prefixSum;
    int totalSum = 0;

    public RandomPickWithWeight(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        prefixSum[0] = w[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        this.totalSum = this.prefixSum[n - 1];
    }

    /**

     */

    public int pickIndex() {
        int n = prefixSum.length;
        double randNum = Math.random() * this.totalSum;
        // for (int i = 0; i + 1 < n; i++) {
        //     int lowerBound = prefixSum[i];
        //     int upperBound = prefixSum[i + 1];
        //     if (randNum > lowerBound && randNum <= upperBound) {
        //         return i + 1;
        //     }
        // }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (randNum > this.prefixSum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
}

class Test {
    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        RandomPickWithWeight obj = new RandomPickWithWeight(w);
        int p1 = obj.pickIndex();
        int p2 = obj.pickIndex();
        int p3 = obj.pickIndex();
        int p4 = obj.pickIndex();
        System.out.println("output: p1: "+p1+"\n p2: "+p2+"\n p3: "+p3+"\n p4: "+p4);
    }
}