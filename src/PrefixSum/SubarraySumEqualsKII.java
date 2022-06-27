package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKII {
    public int subarraySumEqualsKII(int[] nums, int k) {
        // use hash map to store the prefix sum and the end index
        Map<Integer, Integer> sum2end = new HashMap<>();
        int prefixSum = 0;
        int minLen = Integer.MAX_VALUE;
        sum2end.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum - k;
            if (sum2end.containsKey(rem) && minLen > sum2end.get(rem) - i + 1) {
                minLen = Math.min(minLen, i - sum2end.get(rem));
            }
            sum2end.put(prefixSum, i);
        }
        return minLen;
    }


    public static void main(String[] args) {
        SubarraySumEqualsKII sol = new SubarraySumEqualsKII();
        int[] array = {1, 1, 1};
        System.out.println(sol.subarraySumEqualsKII(array, 2));
    }
}
