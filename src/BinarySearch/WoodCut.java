package BinarySearch;

public class WoodCut {
    public int woodCut(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // left and right represent the potential length of the small piece of wood
        int left = 1, right = 1;
        long sum = 0;
        for (int i : array) {
            right = Math.max(right, i);
            sum += i;
        }
        //sanity check
        if (sum < k) {
            return 0;
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isValid(array, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return isValid(array, k, left) ? left : right;
    }

    private boolean isValid(int[] array, int k, int len) {
        int count = 0;
        for (int a : array) {
            count += a / len;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        WoodCut sol = new WoodCut();
        int[] array = {232,124,456};
        System.out.println(sol.woodCut(array, 7));
    }
}
