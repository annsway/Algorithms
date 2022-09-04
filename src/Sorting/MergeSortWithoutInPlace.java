package Sorting;

import java.util.Arrays;

public class MergeSortWithoutInPlace {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        return split(array, 0, array.length - 1);
    }

    private int[] split(int[] array, int left, int right) {
        if (left == right) {
//            System.out.println("---- " + Arrays.toString(new int[left]));
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftPart = split(array, left, mid);
        int[] rightPart = split(array, mid + 1, right);
        return merge(leftPart, rightPart);
    }

    private int[] merge(int[] one, int[] two) {
        int[] res = new int[one.length + two.length];
        int index = 0, i = 0, j = 0;
        while (i < one.length && j < two.length) {
            if (one[i] < two[j]) {
                res[index++] = one[i++];
            } else {
                res[index++] = two[j++];
            }
        }
        while (i < one.length) {
            res[index++] = one[i++];
        }
        while (j < two.length) {
            res[index++] = two[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        MergeSortWithoutInPlace ms = new MergeSortWithoutInPlace();
        System.out.println(Arrays.toString(ms.mergeSort(new int[]{3, 5, 1, 2, 4, 8})));
    }
}
