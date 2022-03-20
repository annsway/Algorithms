package Sorting;

import java.util.Arrays;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0;
        int i = 0;
        int right = array.length - 1;
        /**
         [0, left): -1
         [left, i): 0
         [i, right): unexplored
         [right, n - 1]: 1
         */
        while (i <= right) {
            if (array[i] == -1) {
                swap(array, left++, i++);
            } else if (array[i] == 0) {
                i++;
            } else {
                swap(array, i, right--);
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
        RainbowSort rs = new RainbowSort();
//        int[] arr = {3, 1, 1, 4, 2};
        int[] array = {-1,0,0,1,1};
        System.out.println(Arrays.toString(rs.rainbowSort(array)));
    }

}
