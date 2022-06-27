package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sum2end = new HashMap<>();
        sum2end.put(0, -1);
        int prefixSum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum - k;
            if (!sum2end.containsKey(prefixSum)) {
                sum2end.put(prefixSum, i);
            } else if (sum2end.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - sum2end.get(rem));
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    public static void main(String[] args) {
        MaxSubarraySumEqualsK sol = new MaxSubarraySumEqualsK();
        int[] arr = {1,1,0};
        System.out.println(sol.maxSubArrayLen(arr, 1));
    }
}
