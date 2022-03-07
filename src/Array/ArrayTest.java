package Array;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        System.out.println(Arrays.deepToString(array)); // [null, null]
//        array[0][1] = {{1}};// For 2-D array: Array initializer is not allowed here
        array[0] = new int[0];
        array[1] = new int[1];
        System.out.println(Arrays.deepToString(array)); // [[], [0]]
    }
}
