package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/** Algo:
 * A. Initialize a list = {}
 * // list[n - 1] represents the last element of the longest increasing subsequences from [0, i]
 *
 * B. Traverse the input array
 * if arr[i] > arr[i - 1]:
 * 	list.add(arr[i])
 * else:
 * 	// binary search on the list to find the smallest element that is >= arr[i], and replace it with arr[i]
 * 	// Q: why replace?
 * 	// A: a. replace won't change the result of the LIS
 * 	//    b. by replacing the former elements with a smaller element arr[i], we are making the way for the later elements
 * 	//       that could fall between [arr[i], former] so that they have the potential to form an even
 * 	//       longer increasing subsequences.
 *
 * return list.size()
 * */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] > list.get(list.size() - 1)) {
                list.add(array[i]);
            } else {
                // binary search
                int index = findSmallestGreater(list, array[i]);
                if (index != -1) {
                    list.set(index, array[i]);
                }
            }
//            System.out.println("a[i] = " + array[i] + " " + list);
        }
        return list.size();
    }

    private int findSmallestGreater(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (list.get(left) >= target) {
            return left;
        } else if (list.get(right) > target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence();
        System.out.println(sol.lengthOfLIS(new int[] {4, 10, 4, 3, 8, 9})); // 3
    }
}
