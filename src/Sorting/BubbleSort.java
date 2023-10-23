package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort sol = new BubbleSort();
        System.out.println(Arrays.toString(sol.sortArray(new int[]{3, 5, 1, 2, 4, 8})));
//        System.out.println(Arrays.toString(sol.sortArray(new int[]{0,1,2,3,5,4,6,7,8,9})));
    }
}
