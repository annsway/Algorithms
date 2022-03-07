package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumAllPairsII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (left > 0 && array[left] == array[left - 1]) {
                break;
            }
            int curSum = array[left] + array[right];
            if (curSum == target) {
                res.add(Arrays.asList(array[left], array[right]));
                left++; //
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
        TwoSumAllPairsII sol = new TwoSumAllPairsII();
        System.out.println(sol.allPairs(new int[]{3, 5, 4, 1, 2}, 6));
    }
}
