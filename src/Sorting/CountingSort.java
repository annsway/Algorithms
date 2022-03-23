package Sorting;

import java.util.Arrays;

public class CountingSort {
    public int[] sortArray(int[] array, int k) {
        int min = getMin(array);
        int max = getMax(array);
        int[] helper = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - min;
            helper[index]++;
        }
        int index = 0;
        int j = 0;
        while (j < helper.length) {
            if (helper[j]-- > 0) {
                array[index++] = j + min;
            } else {
                j++;
            }
        }
        return array;
    }
    private int getMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    private int getMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        CountingSort sol = new CountingSort();
//        System.out.println(Arrays.toString(sol.sortArray(new int[]{-1, 5, 2, 3, 1}, 5)));
//        System.out.println(Arrays.toString(sol.sortArray(new int[]{5, 2, 3, 1}, 4)));
        System.out.println(Arrays.toString(sol.sortArray(new int[]{1,3,4,2,5,2,1}, 5)));

    }
}

// TC: O(n + k) // n is the length of the input array, k is the **range** of the input array (max - min + 1).
// SC: O(n + k) // n is the result array, k is the size of the helper array created on the heap