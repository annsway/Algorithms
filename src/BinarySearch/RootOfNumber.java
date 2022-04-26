package BinarySearch;

public class RootOfNumber {
    static double root(double x, int n) {
        double left = 0;
        double right = x;
        double mid = left + (right - left) / 2;
        while (right - left >= 0.0001) {
            mid = left + (right - left) / 2;
            if (Math.pow(mid, n) > x) {
                right = mid ;
            } else if (Math.pow(mid, n) < x) {
                left = mid ;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        RootOfNumber sol = new RootOfNumber();
        System.out.println(sol.root(27, 3));
    }
}
