package DP;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max1 = helper(nums, 0, nums.length - 2);
        int max2 = helper(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    public int helper(int[] nums, int lo, int hi) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = lo; i <= hi; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);

            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob, notRob);
    }

    public static void main(String[] args) {
        HouseRobberII sol = new HouseRobberII();
        int[] nums = {1,2,1,1}; //3
        System.out.println(sol.rob(nums));
    }
}
