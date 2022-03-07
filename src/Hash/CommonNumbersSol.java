package Hash;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersSol {
    // Time = O(m*logn)
    // Extra Space O(1)
    public List<Integer> common(int[] A, int[] B) {
        // Write your solution here
        List<Integer> common = new ArrayList<Integer>();
        // For each element in array a, run a binary search in array b
        // Assume A.length <<<<< B.length
        int left = 0; // we do binary search start from index left in B
        int i = -1; // initialize i
        for (int ele : A) {
            // i is the index in B returned if we find a common element, if no such element i = -1
            i = firstOccur(B, ele, left);
            if (i != -1) {
                common.add(ele);
                // if find element, reset left to i +1 and continue binary search
                // 因为两个array都是有序的，所以每次找的candidate一定不会出现在上一个candidate之前
                left = i + 1;
                // if left if already out of bound, break the loop and don't need to search anymore
                if (left == B.length) {
                    break;
                }
            }
        }
        return common;
    }

    public int firstOccur(int[] array, int target, int left) {
        // Time O(log n) Space O(1)
        if (array == null || array.length == 0) {
            return -1;
        }
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target <= array[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        CommonNumbersSol sol = new CommonNumbersSol();
        System.out.println(sol.common(new int[]{1, 1, 2, 2, 3}, new int[]{1, 1, 2, 5, 6}));
    }
}
