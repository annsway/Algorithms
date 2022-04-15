package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            // deduplicate
            if (i >= 2 && array[i - 2] == array[i]) {
                continue;
            }
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                if (sum == target) {
                    res.add(new ArrayList<>(Arrays.asList(array[i], array[j], array[k])));
                    // deduplicate
                    j++;
                    while (j < k && array[j - 1] == array[j]) {
                        j++;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.allTriples(new int[]{1,1,1,1,1,1,1,1,1,1,1}, 3));
    }
}
