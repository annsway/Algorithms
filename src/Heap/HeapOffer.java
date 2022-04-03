package Heap;

import java.util.Arrays;

public class HeapOffer {
    public int[] offerHeap(int[] array, int ele) {
        array[array.length - 1] = ele;
        percolateUp(array, array.length - 1); // assume array length is sufficient
        return array;
    }
    private void percolateUp(int[] array, int index) {
        // from last element up
        while (index >= 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(array, parent, index);
            } else {
                break;
            }
            index = parent;
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        HeapOffer sol = new HeapOffer();
        System.out.println(Arrays.toString(sol.offerHeap(new int[]{2, 3, 0}, 1)));
    }
}
