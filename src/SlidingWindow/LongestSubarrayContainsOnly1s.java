package SlidingWindow;

public class LongestSubarrayContainsOnly1s {
    public int longestConsecutiveOnes(int[] nums, int k) {
        // Write your solution here
        int maxLen = 0;
        int end = 0;
        int used = 0; // to record the # of 1s used in the window
        for (int start = 0; start < nums.length; start++) {
            while (end < nums.length && (used < k || nums[end] == 1)) {
                if (nums[end] == 0) {
                    used++;
                }
                end++;
            }
            if (used <= k) {
                maxLen = Math.max(maxLen, end - start);
            }
            if (nums[start] == 0) {
                used--;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayContainsOnly1s sol = new LongestSubarrayContainsOnly1s();
//        System.out.println(sol.longestConsecutiveOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // expected: 6
//        System.out.println(sol.longestConsecutiveOnes(new int[]{0,1,0,0,1,0,1,0,1,1,0,1}, 4)); // expected: 9
        System.out.println(sol.longestConsecutiveOnes(new int[]{0,1,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,0,0,1,0,0,0,1,1,1,0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0,0,1,1,0,1,0,0,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,0,1,0,1,1,0}, 89)); // 86
    }
}
