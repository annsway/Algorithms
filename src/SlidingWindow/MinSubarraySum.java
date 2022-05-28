package SlidingWindow;

public class MinSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int globalMin = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                globalMin = Math.min(globalMin, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return globalMin;
    }

    public static void main(String[] args) {
        MinSubarraySum sol = new MinSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(sol.minSubArrayLen(7, nums));
    }
}
