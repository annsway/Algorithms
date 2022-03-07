package Greedy;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

public class TwoSumSmaller {
    public int smallerPairs(int[] array, int target) {
        Arrays.sort(array);
        int count = 0;
        for (int left = 0; left < array.length - 1; left++) {
            int right = array.length - 1;
            while (left < right) {
                int curSum = array[left] + array[right];
                if (curSum < target) {
                    count++;
                }
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TwoSumSmaller sol = new TwoSumSmaller();
        System.out.println(sol.smallerPairs(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(sol.smallerPairs(new int[]{3, 4, 2, 7, 8}, 7));
//        System.out.println(sol.smallerPairs(new int[]{3,4,0,-1,2,0,5}, 7)); // expected: 17
    }
}
