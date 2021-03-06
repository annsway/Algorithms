package TwoPointers;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                int greater = i + 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j] && nums[j] < nums[greater]) {
                        greater = j; // update greater index to find the smallest greater than small
                    }
                }
                swap(nums, i, greater);
                break;
            }
            i--;
        }
        reverse(nums, i + 1, nums.length - 1);
    }
//    public void nextPermutation(int[] nums) {
//        int i = nums.length - 2;
//        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            i--;
//        }
//        int j = nums.length - 1;
//        if (i >= 0) {
//            while (j >= 0 && nums[j] <= nums[i]) {
//                j--;
//            }
//            swap(nums, i, j);
//        }
//        reverse(nums, i + 1, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();
        int[] nums = {1, 3, 2};
//        int[] nums = {3, 2, 1};
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
