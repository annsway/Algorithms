package BinarySearch;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // left part contains monotonically increasing
            else if (nums[left] <= nums[mid]) {
                if (target > nums[left] && target < nums[mid]) {
                    // 当 target 在『左』递增区间内，移动右挡板，process 左递增区间
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right part contains monotonically increasing
                if (target < nums[right] && target > nums[mid]) {
                    // 当 target 在『右』递增区间内，移动左挡板，process 右递增区间
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchRotatedSortedArray sol = new SearchRotatedSortedArray();
        System.out.println(sol.search(nums, 0));
    }
}
