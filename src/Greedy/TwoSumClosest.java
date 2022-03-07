package Greedy;

import java.util.Arrays;
import java.util.List;

public class TwoSumClosest {
    public List<Integer> closest(int[] array, int target) {
        Pair closest = new Pair(Integer.MAX_VALUE, Arrays.asList(-1, -1));
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int cur = array[left] + array[right];
            int curDiff = Math.abs(cur - target);
            if (curDiff <= closest.diff) {
                closest.diff = curDiff;
                closest.pair.set(0, array[left]);
                closest.pair.set(1, array[right]);
            }
            if (cur > target) {
                right--;
            } else {
                left++;
            }
        }
        return closest.pair;
    }

    static class Pair {
        int diff;
        List<Integer> pair;

        public Pair(int diff, List<Integer> pair) {
            this.diff = diff;
            this.pair = pair;
        }
    }

    public static void main(String[] args) {
        TwoSumClosest sol = new TwoSumClosest();
//        System.out.println(sol.closest(new int[]{1, 2}, 100));
        System.out.println(sol.closest(new int[]{3,4,1,-1,2,0,5}, 0));
    }
}
