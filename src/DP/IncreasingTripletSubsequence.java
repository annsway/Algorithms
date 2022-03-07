package DP;

public class IncreasingTripletSubsequence {
    // Greedy
    public static boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) { // update small if n is smaller than both
                small = num;
            } else if (num <= big) { // update big only if greater than small but smaller than big
                big = num;
            } else {
                return true; // return if you find a number bigger than both
            }
        }
        return false;
    }

    // DP: TC: O(n); SC: O(n) // n is the length of input array
    public static boolean increasingTriplet2(int[] nums) {
        // corner case
        if (nums == null || nums.length < 3) {
            return false;
        }
        // M[i] represents the maximum number of increasing numbers at index i
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min1) {
                min1 = nums[i];
            } else {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < min2 && nums[j] > min1) {
                        min2 = nums[j];
                    } else if (nums[j] > min2) {
                        return true;
                    }
                }
                // if not return true, then the min1 should be updated.
                // reset min1
                min1 = Integer.MAX_VALUE;
                min2 = Integer.MAX_VALUE;
            }
        }
        return false;
    }

    public static boolean increasingTriplet1(int[] nums) {
        // corner case
        if (nums == null || nums.length < 3) {
            return false;
        }
        // Greedy
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            } else if (num > min2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(increasingTriplet(new int[]{2, 3, 1, 3})); // false
//        System.out.println(increasingTriplet(new int[]{1, 5, 2, 4})); // true
//        System.out.println(increasingTriplet(new int[]{0, 4, 2, 1, 0, -1, -3})); // false
//        System.out.println(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13})); // true
        System.out.println(increasingTriplet(new int[]{20, 100, 10, 10, 90})); // false
    }
}
