package Array;

import java.util.Arrays;

public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                // left larger part | right smaller part
                swap(array, i, n - 1 - i);
            }
        }
        return new int[]{getMax(array, 0, (n - 1) / 2), getMin(array, n / 2, n - 1)};
    }

    private int getMax(int[] array, int start, int end) {
        int max = array[start];
        for (int i = start + 1; i <= end; i++) {
            max = Math.max(array[i], max);
        }
        return max;
    }

    private int getMin(int[] array, int start, int end) {
        int min = array[start];
        for (int i = start + 1; i <= end; i++) {
            min = Math.min(array[i], min);
        }
        return min;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        LargestAndSmallest sol = new LargestAndSmallest();
        System.out.println(Arrays.toString(sol.largestAndSmallest(new int[]{2,3,1})));
    }
}
