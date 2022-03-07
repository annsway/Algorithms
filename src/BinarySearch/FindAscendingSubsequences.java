package BinarySearch;

import java.util.*;

public class FindAscendingSubsequences {
    public int numIncreasingSubsequences(int[] a) {
        int count = 0;
        int[] M = new int[a.length];
        // M[i] is the number of ascending subsequences ending at index i
        for (int i = 0; i < M.length; i++) {
            M[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    M[i] += M[j];
                }
            }
            count += M[i];
        }
        return count;
    }

    public static void main(String[] args) {
        FindAscendingSubsequences sol = new FindAscendingSubsequences();
        System.out.println(sol.numIncreasingSubsequences(new int[]{1, 2, 3})); // expected: 7
    }
}
