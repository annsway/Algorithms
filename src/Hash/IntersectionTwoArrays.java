package Hash;

import java.util.*;

public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

//        The following API only works for reference types
//        Foo[] array = list.toArray(new Foo[0]);
//        or:
//        Foo[] array = new Foo[list.size()];
//        list.toArray(array); // fill the array

//        Integer[] res = new Integer[list.size()];
//        list.toArray(res);

        // for primitive types, you can only use the following
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer num: list) {
            res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionTwoArrays sol = new IntersectionTwoArrays();
        int[] a = {1, 1, 2, 3};
        int[] b = {1, 2};
        System.out.println(Arrays.toString(sol.intersection(a, b)));
    }
}
