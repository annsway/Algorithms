package Array;

import java.util.Arrays;

public class ArrayDedupV {
    /** array[slow - 1] is the last element of the result
     input: 1,2,2,3,2,2,2,3,3,3,3
      0 1 2 3 4 5 6 7 8 9 10
     {1,2,2,3,2,2,3,3,3,3,3}  expected [1, 2, 2, 3, 2, 2, 3, 3]
                      s
                            f
     */
    public int[] dedup(int[] array) {
        if (array == null || array.length <= 2) {
            return array;
        }
        int slow = 2;
        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[slow - 1] || array[i] != array[slow - 2]) {
                array[slow++] = array[i];
            }
        }
        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {
        ArrayDedupV sol = new ArrayDedupV();
//        System.out.println(Arrays.toString(sol.dedup(new int[]{2, 3, 1, 2, 2, 2, 2, 3, 3, 3})));
        System.out.println(Arrays.toString(sol.dedup(new int[]{1, 2, 2, 3, 2, 2, 2, 3, 3, 3, 3})));
        // expected [1, 2, 2, 3, 2, 2, 3, 3]
    }
}
