package Heap;

import java.util.Arrays;

public class HeapUpdate {
    public int[] updateHeap(int[] array, int index, int ele) {
        // replace old with new ele
        array[index] = ele;
        int parent = (index - 1) / 2;
        if (parent > 0 && array[parent] > array[index]) {
            percolateUp(array, index);
        } else if (parent <= 0 || array[parent] < array[index]) {
            percolateDown(array, index);
        }
        return array;
    }
    private void percolateUp(int[] array, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(array, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }
    private void percolateDown(int[] array, int parent) { // [100, 20, 30, 40]
        while (parent <= array.length / 2 - 1) {
            int lChild = 2 * parent + 1;
            int rChild = 2 * parent + 2;
            int smaller = lChild;
            if (rChild <= array.length - 1 && array[rChild] < array[smaller]) {
                smaller = rChild;
            }
            if (array[smaller] < array[parent]) {
                swap(array, smaller, parent);
                parent = smaller;
            } else {
                break;
            }
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        HeapUpdate sol = new HeapUpdate();
        System.out.println(Arrays.toString(sol.updateHeap(new int[]{1, 20, 30, 40}, 0, 100)));
    }
}
