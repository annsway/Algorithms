package BinarySearch;

import java.util.Arrays;

public class SolBinarySearch {
    public static void main(String[] args) {
        int[] res = kClosest(new int[]{1, 4, 6},3,3);
        System.out.println(Arrays.toString(res));
    }
    public static int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[0];
        }
        int closest = closestSmaller(array, target);
        int[] res = new int[k];

        int i = 0;
        int left = closest - k/2;
        int right = closest + k/2;
        while (i < k) {
            if (right >= array.length ||
                    left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[left] - target)) {
                for (int j = left; j <= closest && i < k; j++) {
                    res[i++] = array[j];
                }
                left = left - i / 2;
            } else {
                for (int j = closest + 1; j <= right && i < k; j++) {
                    res[i++] = array[j];
                }
                right = right + i / 2;
            }
        }
        return res;
    }

    private static int closestSmaller(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // post-processing
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
