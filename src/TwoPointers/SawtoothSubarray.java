package TwoPointers;

import java.util.Arrays;

public class SawtoothSubarray {
    public static int count(int[] arr) {
        int start = 0, end = 0, len = arr.length, count = 0;
        while (end < len) {
            if (arr[start] == arr[end]) {
                end++;
            } else {
                arr[++start] = arr[end++];
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(arr, start + 1)));
        // reset
        len = start + 1;
        start = 0;
        end = 1;
        while (end < len) {
            if ((start + 1 == end) || ((arr[end - 1] - arr[end - 2]) * (arr[end - 1] - arr[end]) > 0)) {
                end++;
            } else {
                int n = end - start; // last index is (end - 1)
                count += n * (n - 1) / 2;
                start = end - 1;
                end = start + 1;
            }
        }
        int n = end - start; // last index is (end - 1)
        count += n * (n - 1) / 2;
        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 1, 2, 1}; // expected: 10
//        int[] arr = {9, 8, 7, 6, 5}; // 4
        int[] arr = {5, 1, 3, 7, 4}; // 6
//        int[] arr = {10, 10, 10}; // 0
//        int[] arr = {1, 2, 2, 2, 3}; //
        System.out.println(SawtoothSubarray.count(arr));
    }
}
