package Sorting;

import java.util.Arrays;

public class QuickSelect {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }
        partition(array, k - 1, 0, array.length - 1);
        int[] res = Arrays.copyOfRange(array, 0, k);
        Arrays.sort(res);
        return res;
    }

    private void partition(int[] array, int k, int leftBound, int rightBound) {
        int index = quickSelect(array, leftBound, rightBound);
        if (index == k) {
            return;
        } else if (index < k) {
            partition(array, k, index + 1, rightBound);
        } else {
            partition(array, k, leftBound, index - 1);
        }
    }

    private int quickSelect(int[] array, int leftBound, int rightBound) {
        int pivotIndex = leftBound + (int) ((Math.random() * (rightBound - leftBound)) / 2);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, rightBound);
        int left = leftBound, right = rightBound - 1;
        while (left <= right) {
            if (array[left] < pivot) {
                left++;
            } else {
                swap(array, left, right);
                right--;
            }
        }
        swap(array, left, rightBound);
        return left;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        QuickSelect sol = new QuickSelect();
        System.out.println(Arrays.toString(sol.kSmallest(new int[]{4, 5, 8, 2, 1}, 3)));
        System.out.println(Arrays.toString(sol.kSmallest(new int[]{1}, 1)));
    }
}