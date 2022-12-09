package BinarySearch;

import java.util.Arrays;

public class MedianOfTwoArrays {
    public double median(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        int m = a.length, n = b.length, k = (m + n + 1) / 2;
        System.out.println("k: " + k);
        if ((m + n) % 2 == 0) {
            int one = helper(a, b, 0, 0, k);
            int two = helper(a, b, 0, 0, k + 1);
            System.out.println("one: " + one + " two: " + two);
            return (double)(one + two) / 2;
        } else {
            return helper(a, b, 0, 0, k);
        }
    }

    private int helper(int[] a, int[] b, int aLeft, int bLeft, int k) {
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        } else if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        } else if (k == 1) {
            return Math.min(a[aLeft], b[bLeft]);
        }
        int aMid = aLeft + k / 2 - 1;
        int bMid = bLeft + k / 2 - 1;

        int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
        int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];

        if (aVal <= bVal) {
            return helper(a, b, aMid + 1, bLeft, k - k / 2);
        } else {
            return helper(a, b, aLeft, bMid + 1, k - k / 2);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoArrays sol = new MedianOfTwoArrays();
        int[] a = {9,11,5,10,8};
        int[] b = {3,4,2};
        System.out.println(sol.median(a, b)); // 6.5
//        int[] a = {};
//        int[] b = {1};
//        System.out.println(sol.median(a, b)); //
    }
}

/**
 * k = (3 + 5 + 1) / 2 = 4
 * [2, 3, 4],[5, 8, 9, 10, 11]
 *            ^
 *               ^
 * */