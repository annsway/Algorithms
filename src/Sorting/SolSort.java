package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SolSort {
    public static int[] quickSort(int[] array) {
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }
    private static void quickSort(int[] array, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // sub-problems
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, pivotIndex, right);
        int pivot = array[right];
        pivotIndex = right;
        right = right - 1;
        while (left <= right) {
            if (array[left] < pivot) {
                left++;
            } else if (array[right] >= pivot) {
                right--;
            } else {
                swap(array, left++, right--);
            }
        }
        swap(array, left, pivotIndex);
        quickSort(array, 0, right);
        quickSort(array, left + 1, array.length - 1);
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 6, 1};
        System.out.println(Arrays.toString(quickSort(arr)));
    }
}

