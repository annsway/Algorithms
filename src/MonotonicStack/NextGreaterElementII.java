package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        // deStack is used for storing the monotonically descreasing values represented by index
        Deque<Integer> deStack = new ArrayDeque<>();

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < n; i++) {
                while (!deStack.isEmpty() && nums[deStack.peekFirst()] <= nums[i]
                        && res[deStack.peekFirst()] == -1) {
                    int smallerIdx = deStack.pollFirst();
                    int nextGreater = nums[i];
                    res[smallerIdx] = nextGreater;
                }
                deStack.offerFirst(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        NextGreaterElementII sol = new NextGreaterElementII();
        int[] nums = {3, 8, 4, 1, 2};
        System.out.println(Arrays.toString(sol.nextGreaterElements(nums)));
    }
}
