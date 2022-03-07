package TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumUnsorted {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.get(rem) != null) {
                res[0] = map.get(rem);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumUnsorted sol = new TwoSumUnsorted();
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(sol.twoSum(nums, 6)));
    }
}
