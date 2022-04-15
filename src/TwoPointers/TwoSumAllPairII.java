package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int curSum = array[left] + array[right];
            if (curSum == target) {
                res.add(Arrays.asList(array[left], array[right]));
                left++;
                // de-duplicate
                while (left < right && array[left] == array[left - 1]) {
                    left++;
                }
            } else if (curSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumAllPairII sol = new TwoSumAllPairII();
//        System.out.println(sol.allPairs(new int[]{3,9,1,2,3}, 4 ));
        System.out.println(sol.allPairs(new int[]{1, 1, 1, 1, 1}, 2));

    }
}
