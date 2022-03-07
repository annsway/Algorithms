package BinarySearch;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // my idea: find the last smaller one of target
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else if (nums[right] < target) {
            return right + 1;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();
//        System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(sol.searchInsert(new int[]{1,3}, 1)); // expected: 0
    }
}
