package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartitionMinDiff {
    //    public static int minDifference(int[] array) {
//        int sum = 0;
//        int globalMin = Integer.MAX_VALUE;
//        int n = array.length;
//
//        int[] nums = new int[n];
//        int org = 10000;
//        for (int i = 0; i < n; i++) {
//            nums[i] = array[i] + org; // 右移
//            sum += nums[i];
//        }
//        // M[i][j] represents the max sum (<= j) for the first i elements
//        int[][] M = new int[n + 1][sum + 1];
//        // N[i][j] represents the size of one subset to achieve M[i][j].
//        int[][] N = new int[n + 1][sum + 1];
//        for (int i = 1; i < M.length; i++) {
//            for (int j = 1; j < M[0].length; j++) {
//                M[i][j] = M[i - 1][j - 1];
//                if (nums[i - 1] >= 0 && j - nums[i - 1] >= 0 && j - nums[i - 1] <= j) { // j - nums[i - 1] represents the max weight needed before adding item i
//                    int curSum;
//                    if (nums[i - 1] >= 0) {
//                        curSum = M[i - 1][j - nums[i - 1]] + nums[i - 1]; // positive
//                    } else {
//                        curSum = M[i - 1][j + nums[i - 1]] + nums[i - 1]; // negative
//                    }
//                    if (M[i][j] < curSum) {
//                        M[i][j] = curSum;
//                        N[i][j] = N[i - 1][j - 1] + 1;
//                    }
//                }
//                if (M[i][j] * 2 <= sum && N[i][j] <= n / 2) { // equal sum as much as possible
//                    globalMin = Math.min(globalMin, sum - 2 * M[i][j]);
//                }
//
//            }
//        }
//        return globalMin;
//    }
    public static int minDifference(int[] array) {
        // Write your solution here
        int n = array.length;
        Map<Integer, Set<Integer>> sumToSize = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        sumToSize.put(0, set);
        int totalSum = 0;
        for (int num : array) {
            totalSum += num;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int num : array) {
            if (sumToSize.size() == 0) {
                set = new HashSet<>();
                minDiff = update(n, 1, num, totalSum, minDiff);
                set.add(1);
                sumToSize.put(num, set);
            } else {
                Map<Integer, Set<Integer>> sumToSizeCopy = new HashMap<>(); // key是sum值，value是花了多少个元素用set存
                deepCopy(sumToSizeCopy, sumToSize);
                for (Map.Entry mapElement : sumToSizeCopy.entrySet()) {
                    Integer sum = (Integer) mapElement.getKey();
                    for (Integer size : (Set<Integer>) mapElement.getValue()) {
                        minDiff = update(n, size + 1, sum + num, totalSum, minDiff);
                        set = sumToSize.get(sum + num);
                        if (set == null) {
                            set = new HashSet<>();
                            sumToSize.put(sum + num, set);
                        }
                        set.add(size + 1);
                    }
                }
            }
        }
        return minDiff;
    }

    private static int update(int n, int size, int num, int totalSum, int minDiff) {
        if (n / 2 == size) {
            minDiff = Math.min(Math.abs(2 * num - totalSum), minDiff);
        }
        return minDiff;
    }

    private static void deepCopy(Map<Integer, Set<Integer>> mapCopy, Map<Integer, Set<Integer>> map) {
        for (Map.Entry mapElement : map.entrySet()) {
            Integer num = (Integer) mapElement.getKey();
            mapCopy.put(num, new HashSet<Integer>((Set<Integer>) mapElement.getValue()));
        }
    }

    public static void main(String[] args) {
//        System.out.println(minDifference(new int[]{2,9,0,0,0})); // expected: 7
        System.out.println(minDifference(new int[]{-2, -9, 0, 0, 0}));
//        System.out.println(minDifference(new int[]{5,-2,-10,3})); // expected: 1

    }

}
