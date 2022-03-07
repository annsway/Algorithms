package Heap;

import java.util.Arrays;

public class Heapify {
    public int[] heapify(int[] array) {
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i);
        }
        return array;
    }

    private void percolateDown(int[] array, int index) {
        int n = array.length;
        while (index <= n / 2 - 1) { // traverse all the parent nodes
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int smallCandidate = leftChild;
            if (rightChild < n && array[rightChild] < array[smallCandidate]) {
                smallCandidate = rightChild;
            }
            if (array[smallCandidate] < array[index]) {
                swap(array, index, smallCandidate);
            } else {
                break; // jump out of the while loop
            }
//            index++;
            index = smallCandidate; // ??
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Heapify sol = new Heapify();
//        System.out.println(Arrays.toString(sol.heapify(new int[]{3, 1, 2})));
        System.out.println(Arrays.toString(sol.heapify(new int[]{66, 0, 5, 84, 29})));

    }
}
/**
 * 66
 * /  \
 * 0   5
 * / \
 * 84  29
 */