package Hash;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        int[] smaller;
        int[] bigger;
        if (A.length <= B.length) {
            smaller = A;
            bigger = B;
        } else {
            smaller = B;
            bigger = A;
        }
        int left = 0;
        int right = bigger.length - 1;
        for (int target : smaller) {
            int index = firstOccurrence(bigger, left, right, target);
            if (index != -1) {
                res.add(target);
                left = index + 1; //
            }
        }
        return res;
    }

    private int firstOccurrence(int[] array, int left, int right, int target) {
        if (array == null || array.length == 0 || left == array.length) { //
            return -1;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // post-processing
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        CommonNumbersOfTwoSortedArrays sol = new CommonNumbersOfTwoSortedArrays();
//        System.out.println(sol.common(new int[]{1, 1, 2, 2, 3}, new int[]{1, 1, 2, 5, 6}));
//        System.out.println(sol.common(new int[]{0,0,1,1,3,3,3,6,6,7,11,12,12,14,15,16,20,21,22,25,26}
//                                    , new int[]{0,1,2,4,6,7,8,8,9,10,11,12,15,18,20,20,21,21,23,25,25}));
        System.out.println(sol.common(new int[]{1,2,6,6,6,7,7,9,10,11,12,13,17,17,18,22,23,23,24,26,26}
                                    , new int[]{0,2,3,4,4,4,4,5,6,6,9,13,14,14,16,18,19,19,20,21,22}));
    }
}
