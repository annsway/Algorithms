package BinarySearch;

public class KthSmallestInTwoSortedArrays {
    public int kth(int[] a, int[] b, int k) {
        // Write your solution here
        if (a == null || b == null) {
            return -1;
        }
        int aLeft = 0;
        int bLeft = 0;
        int aVal = 0;
        int bVal = 0;
        while (k > 1) {
            aVal = aLeft + k / 2 - 1 >= a.length ? Integer.MAX_VALUE : a[aLeft + k / 2 - 1];
            bVal = bLeft + k / 2 - 1 >= b.length ? Integer.MAX_VALUE : b[bLeft + k / 2 - 1];
            if (aVal <= bVal) {
                aLeft = aLeft + k / 2;
            } else {
                bLeft = bLeft + k / 2;
            }
            k = k - k / 2; // k = 1
        }
        aVal = aLeft >= a.length ? Integer.MAX_VALUE : a[aLeft + k - 1];
        bVal = bLeft >= b.length ? Integer.MAX_VALUE : b[bLeft + k - 1];
        return Math.min(aVal, bVal);
    }
    /**
     * 使用课上讲的思路，每次比较a和b的第k/2个元素，删除较小的那行的[0-k/2] 个元素
     * while condition: k > 1 --- 不可以是 k >= 1, 否则当k == 1 时，k = k - k/2 == 1 进入死循环。
     * k = k - k / 2 not k = k / 2。 因为当k为odd时，k/2 比实际值小，如果用 k = k/2 会损失1
     * 最后必须再次对 aVal 和 bVal 重新赋值，因为最后一个while loop中aLeft和bLeft的值可能发生变化
     */
    public static void main(String[] args) {
        KthSmallestInTwoSortedArrays sol = new KthSmallestInTwoSortedArrays();
        System.out.println(sol.kth(new int[]{1}, new int[]{2, 3, 5}, 3));
    }
}
