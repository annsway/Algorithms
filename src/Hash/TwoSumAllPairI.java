package Hash;

import java.util.*;

public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (Integer index : indices) {
                    res.add(Arrays.asList(index, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSumAllPairI sol = new TwoSumAllPairI();
        System.out.println(sol.allPairs(new int[]{1, 1, 1, 1, 1},2));
    }
}
