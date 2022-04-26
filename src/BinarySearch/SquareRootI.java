package BinarySearch;

public class SquareRootI {
    public int sqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        SquareRootI sol = new SquareRootI();
        System.out.println(sol.sqrt(18)); // 4
        System.out.println(sol.sqrt(462959863)); //21516
    }
}
