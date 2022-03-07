package BinarySearch;

public class MissingNumberII {
/**
* General approach
* We can use binary search to shrink the search space until we have only two elements in the search space.
* Then the left number + 1 is the missing number.
 *
 * Corner cases
 * array length is 0: return 1
 * array[array.length-1] == array.length: return array.length + 1
 * array[0] > 1: return 1
 * If there is one element, this element must be 1, so the missing number is 2.
* */
    public static int missing(int[] array) {
        if (array == null || array.length == 0) {
            return 1;
        }
        if (array[array.length - 1] == array.length) {
            return array.length + 1;
        }
        if (array[0] == 2) {
            return 1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) { // When search space == 2, break.
            int mid = left + (right - left) / 2;
            if (array[mid] - 1 == mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[left] + 1;
    }

    public static void main(String[] args) {
        System.out.println(missing(new int[]{1,2,3,4,5,6,8}));
    }
}
