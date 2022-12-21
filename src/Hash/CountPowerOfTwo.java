package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPowerOfTwo {
    public static int solution(int[] numbers) {
        // initialize hash table to store counts for each element
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            set.add((int)Math.pow(2, i));
        }
        for (int number : numbers) {
            for (Integer key : set) {
                int y = key - number;
                if (freqMap.containsKey(y)) {
                    res += freqMap.get(y);
                    if (y == number) {
                        // 题目允许重复使用同一个index：pair formed by the same index, e.g. {1, 1}: can be formed using index pair {0, 0} and {1, 1}
                        res += 1;
                    }
//                    System.out.println("y (" + y + ") + number (" + number + ") = power of two (" + key + ")");
                }
            }
        }
        return res / 2; // deduplicate
    }

    public static void main(String[] args) {
        int[] numbers0 = {1, 1};
        System.out.println(CountPowerOfTwo.solution(numbers0));  // should print 3

        int[] numbers1 = {1, -1, 2, 3};
        System.out.println(CountPowerOfTwo.solution(numbers1));  // should print 5

        int[] numbers2 = {2};
        System.out.println(CountPowerOfTwo.solution(numbers2));  // should print 1

        int[] numbers3 = {-2, -1, 0, 1, 2};
        System.out.println(CountPowerOfTwo.solution(numbers3));  // should print 5
    }
}
