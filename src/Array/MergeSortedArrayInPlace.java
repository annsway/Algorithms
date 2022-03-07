package Array;

import java.util.Arrays;

public class MergeSortedArrayInPlace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        // Use nums1 as a placeholder (in place)
//        int i = m - 1;
//        int j = n - 1;
//        for (int p = m + n - 1; p >= 0; p--) {
//            if (j < 0) {
//                break; // when nums2 does not have elements left
//            }
//            if (i >= 0 && nums1[i] > nums2[j]) {
//                nums1[p] = nums1[i--];
//            } else {
//                nums1[p] = nums2[j--];
//            }
//        }
//    }
//[1,2,3,0,0,0]
//        3
//        [2,5,6]
    public static void main(String[] args) {
        MergeSortedArrayInPlace sol = new MergeSortedArrayInPlace();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        sol.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
