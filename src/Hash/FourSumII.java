package Hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                m.put(a + b, m.getOrDefault(a + b, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                cnt += m.getOrDefault(-(c + d), 0);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        FourSumII sol = new FourSumII();
        int[] nums1 = {1,2}, nums2 = {-2,-1}, nums3 = {-1,2}, nums4 = {0,2};
        System.out.println(sol.fourSumCount(nums1, nums2, nums3, nums4));
    }
}
