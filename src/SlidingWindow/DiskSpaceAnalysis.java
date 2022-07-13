package SlidingWindow;

import java.util.*;

/**
 * Find minimum of window k (segmentLength)
 * Return maximum of all minimum
 *
 * Idea:
 * - Use sliding window minimum to find out the minimum of each snapshot window
 * - Use Deque to maintain a monotonically increasing queue represented by index,
 *      while the leftmost element is the index of the minimum of the window
 * */
public class DiskSpaceAnalysis {
    public int maxMinimum (int numComputer, List<Integer> hardDiskSpace, int segmentLength) {
        int maxMin = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < hardDiskSpace.size(); i++) {
            int cur = hardDiskSpace.get(i);
            // 1. when new element is breaking the increasing rule
            while (!deque.isEmpty() && hardDiskSpace.get(deque.peekLast()) > cur) {
                deque.pollLast();
            }
            // 2. when window size is beyond k
            if (!deque.isEmpty() && deque.peekFirst() < i - segmentLength + 1) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            // result
            if (!deque.isEmpty() && i - segmentLength + 1 >= 0) {
                maxMin = Math.max(maxMin, hardDiskSpace.get(deque.peekFirst()));
            }
        }
        return maxMin;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,3,-1,-3,5,3,6,7));
        DiskSpaceAnalysis sol = new DiskSpaceAnalysis();
        System.out.println(sol.maxMinimum(3, nums, 3));
    }
}
