package String;

import java.util.Arrays;

public class ReorderArray {
    public int[] reorder(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] res;
        if (array.length % 2 == 0) {
            res = merge(array, 0, array.length); // even
        } else {
            res = merge(array, 0, array.length - 1); // odd
        }
        return res;
    }

    private int[] merge(int[] array, int left, int end) {
        int[] helper = Arrays.copyOf(array, array.length); // deep copy
        int mid = left + (end - left) / 2;
        int right = mid;
        left++;
        int index = 1;
        while (left < mid && right <= end) {
            helper[index++] = array[right++];
            helper[index++] = array[left++];
        }
        return helper;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        ReorderArray sol = new ReorderArray();
        System.out.println(Arrays.toString(sol.reorder(array)));
    }
}
