package Heap;

import java.util.Arrays;

public class Heapify {
    public int[] heapify(int[] array) {
        // corner case
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, array.length);
        }
/*** Note: we cannot heapify from top down. test case: [4, 1, 2, 8, 5, 3]
 * heapify the array to make it a max heap
 * 1st round: {[4], 1, 2} => 4 is max
 * 2nd round: 4, {[1], 2, 8, 5} => 4 < 8, but 8 will never have a chance to move to top
*/
//        for (int i = 0; i < array.length; i++) {
//            percolateDown(array, i, array.length);
//        }
        return array;
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
        Heapify sol = new Heapify();
//        System.out.println(Arrays.toString(sol.heapify(new int[]{3, 1, 2})));
        System.out.println(Arrays.toString(sol.heapify(new int[]{4,1, 2, 8, 5, 3})));

    }
}
/**
 * 66
 * /  \
 * 0   5
 * / \
 * 84  29
 */