package TwoPointers;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, 0, n - 1);
        k = k % n;
        reverse(nums, 0, k - 1);
        reverse(nums, n - k - 1, n - 1);
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
        RotateArray sol = new RotateArray();
        int[] array = {1,2,3,4,5,6,7}; // [5,6,7,1,2,3,4]
        sol.rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
