package BinarySearch;

public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstOccurrence sol = new FirstOccurrence();
        System.out.println(sol.firstOccur(new int[]{3,3,6,6,9,16}, 3));
    }
}
