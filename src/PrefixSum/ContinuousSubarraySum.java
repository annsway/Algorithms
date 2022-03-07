package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();
        // in case all elements sum up
        prefixSums.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            int count = prefixSums.get(prefixSum) + 1;
            prefixSum += nums[i];
            prefixSums.put(prefixSum, count);
            int rem = prefixSum % k;
            if (rem == 0) {
                if (i + 1 >= 2) {
                    return true;
                }
            }
            if (prefixSums.containsKey(rem) && prefixSums.get(rem) >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum sol = new ContinuousSubarraySum();
//        System.out.println(sol.checkSubarraySum(new int[]{23,2,4,6,7} ,6)); // expected: true
        System.out.println(sol.checkSubarraySum(new int[]{5,0,0,0},3)); // expected: true
    }
}
