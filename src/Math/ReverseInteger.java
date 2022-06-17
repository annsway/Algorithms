package Math;

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        while (x != 0) {
            int cur = x % 10;
            x /= 10;
            // handle overflow
            // compare the last digit of x, represented by "cur", to the last digit of Integer.MIN_VALUE (-8)
            if (res > MAX / 10 || (res == MAX / 10 && cur % 10 > MAX % 10)) {
                return 0;
            } else if (res < MIN / 10 || (res == MIN / 10 && cur % 10 < Math.abs(MIN) % 10)) {
                return 0;
            }
            res = res * 10 + cur;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger sol = new ReverseInteger();
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE); // -214748364[8]
        System.out.println("Math.abs(MIN) % 10 = " + Math.abs(Integer.MIN_VALUE) % 10); // -8
        System.out.println(sol.reverse(-1463847412)); // -2147483641 > Integer.MIN_VALUE
//        System.out.println(sol.reverse(-321));

    }
}
