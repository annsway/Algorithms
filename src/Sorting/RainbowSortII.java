package Sorting;

import java.util.Arrays;

public class RainbowSortII {
    public int[] rainbowSortII(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0, i = 0, j = 0, right = array.length - 1;
/** [0, left): 0
 [left, i): 1
 [i, j): 2
 [j, right): unexplored
 [right, n - 1]: 3 */
        while (j <= right) {
            if (array[j] == 0) {
                swap(array, i, j++);
                swap(array, left++, i++);
            } else if (array[j] == 1) {
                swap(array, i++, j++);
            } else if (array[j] == 2) {
                j++;
            } else {
                swap(array, j, right--);
            }
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        RainbowSortII sol = new RainbowSortII();
        System.out.println(Arrays.toString(sol.rainbowSortII(new int[]{2, 0, 0, 1, 1})));
    }
}
