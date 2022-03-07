package BinarySearch;

public class SquareRootI {
    public int sqrt(int x) {
        if (x <= 1) {
            return 0;
        }
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        SquareRootI sol = new SquareRootI();
//        System.out.println(sol.sqrt(18)); // 4
        System.out.println(sol.sqrt(462959863)); //21516
    }
}
