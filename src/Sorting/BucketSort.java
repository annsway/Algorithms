package Sorting;

import java.util.*;

public class BucketSort {
    public int[] sortArray(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        List<Integer> posNums = new ArrayList<>();
        List<Integer> negNums = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                negNums.add(-num);
            } else {
                posNums.add(num);
            }
        }
        int[] neg = bucketSort(negNums);
        int[] pos = bucketSort(posNums);
        int[] res = new int[nums.length];

        int negIndex = neg.length - 1;
        int sorted = 0;
        while (negIndex >= 0) {
            res[sorted++] = (-1) * neg[negIndex--];
        }
        int posIndex = 0;
        while (posIndex < pos.length) {
            res[sorted++] = pos[posIndex++];
        }
        return res;
    }

    // only takes positive numbers
    private int[] bucketSort(List<Integer> array) {
        int totalBuckets = 9;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] res = new int[array.size()];
        ArrayList[] buckets = new ArrayList[totalBuckets];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        // initialize list
        for (int i = 0; i < totalBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        int interval = (max - min) / totalBuckets + 1;
        // map each number to a bucket
        for (int num : array) {
            int index = (num - min) / interval;
            buckets[index].add(num);
        }
        // sort each bucket
        for (int i = 0; i < totalBuckets; i++) {
            Collections.sort(buckets[i]);
        }
        // put
        int sorted = 0;
        for (ArrayList list : buckets) {
            int index = 0;
            while (index < list.size() && sorted < array.size()) {
                res[sorted++] = (int) list.get(index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BucketSort sol = new BucketSort();
//        System.out.println(Arrays.toString(sol.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
//        System.out.println(Arrays.toString(sol.sortArray(new int[]{3, -1, -5})));
        System.out.println(Arrays.toString(sol.sortArray(new int[]{-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39})));


    }
}
