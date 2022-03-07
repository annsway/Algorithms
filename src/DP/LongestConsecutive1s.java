package DP;

public class LongestConsecutive1s {
    public int longest(int[] array) {
        // sanity check
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] M = new int[array.length];
        // M[i] represents the max consecutive 1s up to index i, including i
        M[0] = array[0] == 1 ? 1 : 0;
        int globalMax = M[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                M[i] = M[i - 1] + 1;
                globalMax = Math.max(M[i], globalMax);
            } else {
                globalMax = Math.max(M[i - 1], globalMax);
                M[i] = 0; // reset
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        LongestConsecutive1s sol = new LongestConsecutive1s();
        System.out.println(sol.longest(new int[]{1,1,1,1,1}));
    }
}
