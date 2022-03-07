package Sorting;

import java.util.Arrays;

public class HeapSort {
    public int[] heapsort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        // heapify the array only once
        heapify(array);
        int i = array.length - 1;
        while (i >= 0) {
            swap(array, 0, i--);
            percolateDown(array, 0, i + 1);
        }
        return array;
    }

    private void heapify(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
    }

    private void percolateDown(int[] array, int index, int n) {
        while (index <= n / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int largerChildIndex = leftChildIndex;
            if (rightChildIndex <= n - 1 && array[rightChildIndex] > array[largerChildIndex]) {
                largerChildIndex = rightChildIndex;
            }
            if (array[largerChildIndex] > array[index]) {
                swap(array, largerChildIndex, index);
            } else {
                break;
            }
            index = largerChildIndex;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort sol = new HeapSort();
        System.out.println(Arrays.toString(sol.heapsort(new int[]{4, 4, 1, 1})));
    }
}
