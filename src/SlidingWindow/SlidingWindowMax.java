package SlidingWindow;

import java.util.*;

public class SlidingWindowMax {
    public List<Integer> maxSlidingWindow(int[] array, int k) {
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            // discard any index with smaller value than index i
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        SlidingWindowMax sol = new SlidingWindowMax();
        int[] input = {4, 4, 2, 3, 0, 5}; // k = 3
/**                             i
 * {4a}
 * {4b}
 * {4b,2}  - res: {4}
 * ----- i = 1
 * {4b,3}
 * {}
 */
        System.out.println(sol.maxSlidingWindow(input, 3));
    }
}