package Hash;

import java.util.*;

public class MinIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, curSum;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                curSum = map.get(list2[i]) + i;
                if (curSum < min_sum) {
                    min_sum = curSum;
                    res.clear();
                    res.add(list2[i]);
                } else if (curSum == min_sum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        MinIndexSumOfTwoLists sol = new MinIndexSumOfTwoLists();
        // test case: when all options are the same and their index sums equal, return all options
        String[] l1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] l2 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(Arrays.toString(sol.findRestaurant(l1, l2)));
    }
}
