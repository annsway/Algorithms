package DP;

public class PartitionEqualSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // M[i][j]
        int[][] M = new int[nums.length + 1][sum + 1];
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                // not add
                M[i][j] = M[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    // nums[i] = current weight; j - nums[i] = the rest of weight
                    M[i][j] = Math.max(M[i][j], M[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
                if (M[i][j] * 2 == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1,2,3,5}));
    }
}
