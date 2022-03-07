package DP;

public class CutMaxProductOfRope {
    public int maxProduct(int n) {
        int[] M = new int[n + 1];
        // M[i] represents the max product from cutting rope of length i at least once
        M[0] = 0; // base case 1
        M[1] = 0; // base case 2 - you cannot cut a one-meter rope into smaller pieces
        for (int i = 2; i <= n; i++) { // 从小到大填表 - grow the rope
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
                // j：不切；这种情况无法被包含在M[j]里，因为M[j]要求至少切一刀
            }
            M[i] = curMax;
        }
        return M[n];
    }

    public static void main(String[] args) {
        CutMaxProductOfRope sol = new CutMaxProductOfRope();
        System.out.println(sol.maxProduct(4));
    }
}
