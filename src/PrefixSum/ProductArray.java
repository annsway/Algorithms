package PrefixSum;

import java.util.Arrays;

public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1, postfix = 1, n = nums.length;
        int[] res = new int[n];
        // First pass: fill the prefix in the res array
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[i] = 1;
                // prefix = res[i];
                continue;
            }
            prefix = nums[i - 1] * prefix;
            res[i] = prefix;
        }
        // Second pass: fill the postfix in the res array
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1) {
                postfix = nums[j] * postfix;
                continue;
            }
            postfix = nums[j] * postfix;
            res[j] = postfix;
        }
        return res;
    }

    public static void main(String[] args) {
        ProductArray sol = new ProductArray();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums)));
    }
}
