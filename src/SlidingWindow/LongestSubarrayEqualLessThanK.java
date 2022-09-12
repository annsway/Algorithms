package SlidingWindow;

public class LongestSubarrayEqualLessThanK {

    public int maxLength(int[] a, int k) {
        int curSum = 0; 
        int start = 0, end = 0, n = a.length; 
        int maxLength = 0; 
        while (end < n) {
            curSum += a[end];
            while (start < n && curSum > k) {
                curSum -= a[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestSubarrayEqualLessThanK sol = new LongestSubarrayEqualLessThanK();
        System.out.println(sol.maxLength(new int[]{1, 2, 3}, 0));
    }
}
