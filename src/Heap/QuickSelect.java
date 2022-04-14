package Heap;

import java.util.Arrays;

public class QuickSelect {
    public int[] kSmallest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k);
        return Arrays.copyOf(nums, k);
    }
    private void quickSelect(int[] nums, int leftBound, int rightBound, int k) {
        if (leftBound > rightBound) {
            return;
        }
        int pivotIndex = rightBound;
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            if (nums[right] <= nums[pivotIndex]) {
                swap(nums, left++, right);
            } else {
                right--;
            }
        }
        swap(nums, left, pivotIndex);
        if (left == k - 1) {
            return;
        } else if (left < k - 1) {
            quickSelect(nums, left + 1, rightBound, k);
        } else {
            quickSelect(nums, leftBound, left - 1, k);
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSelect sol = new QuickSelect();
        System.out.println(Arrays.toString(sol.kSmallest(new int[]{3, 1, 5, 2, 4}, 3)));
    }
}
