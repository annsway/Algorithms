package Array;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] A) {
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i], min = A[i];
            for (int j = i; j < A.length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                res += max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfSubarrayRanges sol = new SumOfSubarrayRanges();
        int[] nums = {1,2,3};
        System.out.println(sol.subArrayRanges(nums));
    }
}
