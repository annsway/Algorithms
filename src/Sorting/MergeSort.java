package Sorting;

import java.util.Arrays;

public class MergeSort {
//    public int[] mergeSort(int[] array) {
//        // corner case
//        if (array == null || array.length == 0) {
//            return array;
//        }
//        int[] helper = new int[array.length]; // used for temporarily store the partially sorted array
//        split(array, 0, array.length - 1, helper);
//        return array;
//    }
//
//    private void split(int[] array, int left, int right, int[] helper) {
//        if (left == right) {
//            return;
//        }
//        int mid = left + (right - left) / 2;
//        split(array, left, mid, helper);
//        split(array, mid + 1, right, helper);
//        merge(array, left, mid, right, helper);
//    }
//
//    private void merge(int[] array, int left, int mid, int right, int[] helper) {
//        // mid is used for split the helper[] into two sub-arrays with the lengths of n/2.
//        // store the current range
//        for (int i = left; i <= right; i++) {
//            helper[i] = array[i];
//        }
//        int leftIndex = left;
//        int rightIndex = mid + 1; // rightIndex = mid; => WRONG! while loop will iterate twice when there's only one element to be sorted, since either leftIndex/rightIndex won't increment
//        // left index is used for point to the current element to be filled in the original array.
//        while (leftIndex <= mid && rightIndex <= right) {
//            if (helper[leftIndex] <= helper[rightIndex]) {
//                array[left++] = helper[leftIndex++];
//            } else {
//                array[left++] = helper[rightIndex++];
//            }
//        }
//        // in case leftIndex has not reached to mid index
//        while (leftIndex <= mid) {
//            array[left++] = helper[leftIndex++];
//        }
//    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
//        System.out.println(Arrays.toString(ms.mergeSort(new int[]{3, 5, 1, 2, 4, 8})));
        System.out.println(Arrays.toString(ms.mergeSort(new int[]{0, 1})));
    }

    public int[] mergeSort(int[] array) {
        return partition(array, 0, array.length - 1);
    }

    private int[] partition(int[] array, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return new int[]{array[leftBound]};
        }
        int mid = leftBound + (rightBound - leftBound) / 2;
        int[] leftPart = partition(array, leftBound, mid);
        int[] rightPart = partition(array, mid + 1, rightBound);
//        int mid = leftBound + (rightBound - leftBound + 1) / 2;
//        int[] leftPart = partition(array, leftBound, mid - 1);
//        int[] rightPart = partition(array, mid, rightBound);
        return mergeSort(leftPart, rightPart);
    }

    private int[] mergeSort(int[] leftPart, int[] rightPart) {
        int n = leftPart.length + rightPart.length;
        int[] res = new int[n];
        int i = 0, j = 0, index = 0;
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] < rightPart[j]) {
                res[index++] = leftPart[i++];
            } else {
                res[index++] = rightPart[j++];
            }
        }
        while (i < leftPart.length) {
            res[index++] = leftPart[i++];
        }
        while (j < rightPart.length) {
            res[index++] = rightPart[j++];
        }
        return res;
    }
}
