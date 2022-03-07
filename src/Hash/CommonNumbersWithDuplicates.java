package Hash;

import java.util.*;

public class CommonNumbersWithDuplicates {
    public List<Integer> common(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : b) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                Integer oldVal = countMap.get(num);
                countMap.put(num, oldVal + 1);
            }
        }
        for (int num : a) {
            if (countMap.containsKey(num)) {
                res.add(num);
                Integer curVal = countMap.get(num) - 1;
//                if (curVal == 0) {
//                    countMap.remove(num); //
//                } else {
//                    countMap.put(num, curVal);
//                }
                countMap.put(num, curVal);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        CommonNumbersWithDuplicates sol = new CommonNumbersWithDuplicates();
        int[] a = {1, 2, 3, 2};
        int[] b = {3, 4, 2};
        System.out.println(sol.common(a, b));
    }
}
