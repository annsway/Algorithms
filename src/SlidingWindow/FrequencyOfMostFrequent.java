package SlidingWindow;

import java.util.Arrays;

public class FrequencyOfMostFrequent {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, slow = 0, fast = 0, max = 1;
        long sum = 0;
        while (fast < n) {
            sum += nums[fast];
            while (sum + k < nums[fast] * (fast - slow + 1)) {
                 System.out.println("slow: " + slow + " fast: " + fast);
                sum -= nums[slow++];
            }
            int curLen = fast - slow + 1;
            max = Math.max(max, curLen);
            fast++;
        }
        return max;
    }

    public static void main(String[] args) {
        FrequencyOfMostFrequent sol = new FrequencyOfMostFrequent();
        int[] array = {3,9,6};
        int k = 2;
        System.out.println(sol.maxFrequency(array, k)); // 1
    }
}
