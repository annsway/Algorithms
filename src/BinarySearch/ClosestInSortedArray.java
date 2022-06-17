package BinarySearch;

public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // post-processing
        if (target - array[left] < array[right] - target) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        ClosestInSortedArray sol = new ClosestInSortedArray();
        System.out.println(sol.closest(new int[]{3,4,5,6,6,12,16}, 10));
    }
}
