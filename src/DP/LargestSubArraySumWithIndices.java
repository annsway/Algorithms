package DP;

import java.util.Arrays;

public class LargestSubArraySumWithIndices {
    public static int[] largestSum(int[] array) {
        // Assumptions: The given array is not null and has length of at least 1.
        int[] M = new int[array.length];
        M[0] = array[0];
        int globalMax = M[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        int tempEnd = 0;
        // M[i] represents the largest subarray sum from index 0 to index i
        for (int i = 1; i < array.length; i++) {
            int curSum = M[i - 1] + array[i];
            if (curSum < array[i]) {
                M[i] = array[i]; // restart
                tempStart = i;
                tempEnd = i;
            } else {
                M[i] = curSum;
                tempEnd = i;
            }
            if (M[i] > globalMax) {
                globalMax = M[i];
                start = tempStart;
                end = tempEnd;
            }
        }
        return new int[]{globalMax, start, end};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(largestSum(new int[]{4, 2, -3, -2, 3, -1, -2, 6}))); // expected: [[7, 0, 7]]
        System.out.println(Arrays.toString(largestSum(new int[]{2,-1,3,1,4,-2,-2,1}))); // expected [9, 0, 4]
        System.out.println(Arrays.toString(largestSum(new int[]{1}))); // expected [1, 0, 0]
        System.out.println(Arrays.toString(largestSum(new int[]{-4,-6,-2,-3}))); // expected [-2, 2, 2]
    }
}

// TC: O(n)
// SC: O(n)