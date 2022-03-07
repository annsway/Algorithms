package Sorting;

import java.util.Arrays;

public class QuickSelect {
    public static int[] kSmallest(int[] array, int k) {
        // assumption: A is not null and K is >= 0 and smaller than or equal to size of A
        helper(array, k - 1, 0, array.length - 1);
        int[] res = Arrays.copyOfRange(array, 0, k);
        Arrays.sort(res);
        return res;
    }

    /**
     和quicksort的不同的是，这个是淘汰赛，每次sort都是选择最右边的那个数，用于淘汰一波波数字直到淘汰到最小的数字为止。
     关键点：
     假如pivot在这个k-1的右边，那么这个pivot的右边以及它本身不再需要，直接从这个数字左边开始。
     假如这个pivot在0到k-1之间，那么, 首先将lower提到pivot右边保护pivot以及它左边，然后保持upper
     当pivot等于k-1，说明刚好pivot和它左边为要的数字，直接return就好。
     总而言之，这个结合了二分法和quicksort的特点。
     * */

    private static void helper(int[] array, int k, int leftBound, int rightBound) {
        int mid = quickSelect(array, leftBound, rightBound); //
        if (mid == k) {
            return;
        } else if (mid > k) {
            helper(array, k, leftBound, mid - 1);
        } else {
            helper(array, k, mid + 1, rightBound);
        }
    }

    private static int quickSelect(int[] array, int leftBound, int rightBound) {
        int pivotIndex = leftBound + (int) (Math.random() * (rightBound - leftBound + 1));
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, rightBound);
        int i = leftBound;
        int j = rightBound - 1;
        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, rightBound); //
        return i; //
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kSmallest(new int[]{10, 2, 1}, 2)));
    }
}
