package Array;

import java.util.Arrays;

public class ArrayDedupIII {
    public int[] dedup(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
/** [0, slow): processed and result
 [slow, fast): explored
 [fast, n): unexplored
 {2,4,5,3,3,4,5,5,5} → {2, 4}
 s
 f
 */
        int slow = 0;
        int fast = 1;
        boolean isDup = false;
        while (fast < array.length) {
            if (array[slow] == array[fast]) {
                isDup = true;
            } else if (isDup) {
                array[slow] = array[fast];
                // 这里的swap是为了将array[fast]移到index slow, 作为下一次iteration的比较
                // 但是这里的 array[slow] 本身不会被算入 result
                isDup = false;
            } else {
                // 这里需要先 ++slow, 是因为 isDup = false, 意味着前一个元素不是duplicate，所以不能覆盖它
                array[++slow] = array[fast];
            }
            fast++;
        }
        return Arrays.copyOfRange(array, 0, isDup ? slow : slow + 1); // test case: {1, 3, 4, 4, 5}
    }

    public static void main(String[] args) {
        ArrayDedupIII sol = new ArrayDedupIII();
        System.out.println(Arrays.toString(sol.dedup(new int[]{1, 3, 4, 4, 5})));
    }
}
