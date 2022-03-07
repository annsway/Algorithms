package PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int prefixSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = prefixSum - k;
//            countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1); // Wrong: {1}, 0
            if (countMap.containsKey(rem)) {
                res += countMap.get(rem);
            }
        }
        countMap.put(prefixSum, countMap.getOrDefault(prefixSum, 0) + 1);
        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK sol = new SubarraySumEqualsK();
//        int[] nums = {1, 2, 3};
//        System.out.println(sol.subarraySum(nums, 3)); // expected: 2
        int[] nums = {1};
        System.out.println(sol.subarraySum(nums, 0)); // expected: 0
    }
}
