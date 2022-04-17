package TwoPointers;

import java.util.*;

public class KdiffPairs {
//    public int findPairs(int[] nums, int k) {
//        int res = 0;
//        Arrays.sort(nums);
//        int left = 0;
//        int right = 1;
//        while (left <= right && right < nums.length) {
//            if (left == right) {
//                right++;
//                continue;
//            }
//            int diff = nums[right] - nums[left];
//            if (diff == k) {
//                res++;
//                left++;
//                right++;
//                while (left < nums.length && nums[left - 1] == nums[left]) {
//                    left++;
//                }
//                while (right < nums.length && nums[right - 1] == nums[right]) {
//                    right++;
//                }
//            } else if (diff < k) {
//                right++;
//            } else {
//                left++;
//            }
//        }
//        return res;
//    }

    public int findPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            Integer oldVal = freqMap.get(num);
            if (oldVal == null) {
                freqMap.put(num, 1);
            } else {
                freqMap.put(num, oldVal + 1);
            }
        }
        for (int num : nums) {
            int rem = num + k;
            if (freqMap.containsKey(rem)) {
                res++;

            }
        }
        return res;
    }

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        // your code goes here
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        while (left <= right && right < arr.length) {
            if (left == right) {
                right++;
                continue;
            }
            int diff = arr[right] - arr[left];
            if (diff == k) {
                list.add(Arrays.asList(arr[left], arr[right]));
                left++;
                right++;
                while (left < arr.length && arr[left - 1] == arr[left]) {
                    left++;
                }
                while (right < arr.length && arr[right - 1] == arr[right]) {
                    right++;
                }
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (List<Integer> cur : list) {
            res[index][0] = cur.get(0);
            res[index][1] = cur.get(1);
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
        KdiffPairs sol = new KdiffPairs();
        System.out.println(sol.findPairs(new int[]{1, 1, 1, 2, 2}, 0));
    }
}
