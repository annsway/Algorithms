package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarray {
    public int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        LongestContinuousSubarray sol = new LongestContinuousSubarray();
        int[] nums = {8,2,4,7};
        System.out.println(sol.longestSubarray(nums, 4));
    }
}
