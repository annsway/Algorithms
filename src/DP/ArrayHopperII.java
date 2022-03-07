package DP;

public class ArrayHopperII {
    public static int minJump(int[] array) {
        // Assumption: The given array is not null and has length of at least 1.
        // sanity check
        if (array.length == 1) {
            return 0;
        }
        int[] M = new int[array.length];
        M[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
                M[i] = 1;
            } else {
                // find the M[bridgeIndex] (min bridge) among all the possible bridges
                int minBridge = Integer.MAX_VALUE;
                for (int bridgeIndex = i + array[i]; bridgeIndex > i; bridgeIndex--) {
                    minBridge = Math.min(minBridge, M[bridgeIndex]);
                }
                M[i] = minBridge == Integer.MAX_VALUE ? Integer.MAX_VALUE : minBridge + 1;
                System.out.println(M[i]);
            }
        }
        return M[0] == Integer.MAX_VALUE ? -1 : M[0];
    }

    public static void main(String[] args) {
//        int[] array = {5,6,0,0,0,10,0,0,0};
        int[] array = {4,2,1,1,0,4};
        System.out.println(minJump(array));
    }
}
/**
 a[i] = 5,6,0,0,0,10,0,0,0
 M[i] =          1 0 0 0
 */