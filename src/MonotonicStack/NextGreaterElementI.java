package MonotonicStack;

import java.util.*;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // deStack is monotonically decreasing
        Deque<Integer> deStack = new ArrayDeque<>();
        // map is used for storing the index of each value to be searched for, map<value, index>
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
            // set default value -1
            res[i] = -1;
        }
        for (int i = 0; i < nums2.length; i++) {
            while (!deStack.isEmpty() && nums2[deStack.peekFirst()] >= nums2[i]) {
                if (nums2[deStack.peekFirst()] == nums2[i]) {
                    break;
                }
                int smaller = nums1[deStack.pollFirst()];
                int nextGreater = nums2[i];

                if (map.containsKey(smaller)) {
                    int index = map.get(smaller);
                    res[index] = nextGreater;
                }
            }
            deStack.offerFirst(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        NextGreaterElementI sol = new NextGreaterElementI();
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2)));
    }
}
