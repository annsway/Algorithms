package DP;

import java.util.Arrays;

public class LongestAscendingSubsequencesII {
    public int[] longest(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        int[] M = new int[array.length];
        // M[i] represents the longest ascending subsequence ending at index i, meaning it must include array[i] in the subsequence
        int endIndex = 0;
        // endIndex represents the end index of the longest ascending subsequence so far
        int globalMax = 0;
        for (int i = 0; i < array.length; i++) {
            M[i] = 1; // an element itself is considered a subsequence with length of 1
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    M[i] = Math.max(M[j] + 1, M[i]); // M[i] might be updated multiple times when looking back
                }
            }
            if (globalMax < M[i]) {
                globalMax = M[i];
                endIndex = i;
            }
        }
        int[] res = new int[globalMax];
        // post-processing
        for (int i = endIndex; i >= 0; i--) {
            if (M[i] == globalMax) {
                res[--globalMax] = array[i]; // --globalMax: index is smaller than the length of an array
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequencesII sol = new LongestAscendingSubsequencesII();
        System.out.println(Arrays.toString(sol.longest(new int[]{5, 2, 6, 3, 4, 7, 5}))); //Output: [2,3,4,7]
    }
}
