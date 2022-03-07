package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) { // de-duplicate
                continue;
            }
            int remainder = target - array[i];
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == remainder) {
                    res.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    // de-duplicate
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (sum < remainder) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.allTriples(new int[]{1, 2, 2, 2}, 6));
    }
}
