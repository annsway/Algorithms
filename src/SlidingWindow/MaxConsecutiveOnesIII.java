package SlidingWindow;

import java.util.Arrays;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int globalMax = 0;
        int rem = k;
        int start = 0;
        int end = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else if (rem > 0) {
                end++;
                rem--;
            } else if (nums[start] == 0) {
                start++;
                rem++;
            } else if (nums[start] == 1) {
                start++;
            }
            globalMax = Math.max(globalMax, end - start);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII sol = new MaxConsecutiveOnesIII();
//        System.out.println(sol.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // expected: 6
        System.out.println(sol.longestOnes(new int[]{0,1}, 2));
        int[] test = {0,1};
        int[] copy = Arrays.copyOfRange(test, 0,1);
        System.out.println(Arrays.toString(copy));
    }
}
