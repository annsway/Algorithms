package DP;

public class LongestAscendingSubsequence {
//    public static int longest(int[] array) {
//        int globalMax = 1;
//        int[] M = new int[array.length];
//        M[0] = 1;
//        // M[i] represents the longest ascending subsequence from index 0 to index i, including i
//        for (int i = 1; i < array.length; i++) {
//            M[i] = 1; // initialize it
//            for (int j = 0; j < i; j++) {
//                if (array[j] < array[i]) {
//                    M[i] = Math.max(M[i], M[j] + 1);
//                }
//            }
//            globalMax = Math.max(globalMax, M[i]);
//        }
//        return globalMax;
//    }

    public int longest(int[] array) {
        int globalMax = 0;
        int[] M = new int[array.length];
        M[0] = 1;
        for (int i = 1; i < array.length; i++) {
            M[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    M[i] = Math.max(M[i], M[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, M[i]);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequence sol = new LongestAscendingSubsequence();
//        System.out.println(sol.longest(new int[]{5, 2, 6, 3, 4, 7, 5})); // expected: 4;  [2, 3, 4, 5]
        System.out.println(sol.longest(new int[]{5, 2, -6, -3, 4, -7, 5})); // expected: 4; [-6,-3,4,5]
    }
}
