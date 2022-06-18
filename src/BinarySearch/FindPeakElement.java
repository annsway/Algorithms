package BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] < nums[right]) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();
        int[] nums = {6,5,4,3,2,3,2};
        System.out.println(sol.findPeakElement(nums));
    }
}
