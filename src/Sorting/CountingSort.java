package Sorting;

import java.util.Arrays;

public class CountingSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        int max = getMaxValue(nums);
        int min = getMinValue(nums);
        int[] helper = new int[max - min + 1];
        for (int num : nums) {
            helper[num - min]++; // offset
        }
        // counting sort
        int sortedIndex = 0; // to traverse input array
        for (int j = 0; j < helper.length; j++) {
            while (helper[j] > 0) {
                res[sortedIndex++] = j + min; // undo offset
                helper[j]--;
            }
        }
        /**
         index i  0  1  2 ...
         input[i] v2 v3 v1 ...

         index j  v1 v2 v3 ...
         helper[j] c1 c2 c3
         */
        return res;
    }

    private int getMinValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private int getMaxValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        CountingSort sol = new CountingSort();
        System.out.println(Arrays.toString(sol.sortArray(new int[]{-1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(sol.sortArray(new int[]{5, 2, 3, 1})));
    }
}

// TC: O(n + k) // n is the length of the input array, k is the **range** of the input array (max - min + 1).
// SC: O(n + k) // n is the result array, k is the size of the helper array created on the heap