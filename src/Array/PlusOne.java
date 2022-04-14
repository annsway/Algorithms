package Array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n + 1];
        int carry = 0;
        int curSum;
        int index = res.length - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                curSum = digits[n - 1] + 1;
            } else {
                curSum = digits[i] + carry;
            }
            if (curSum > 9) {
                carry = 1;
                res[index--] = curSum % 10;
            } else {
                carry = 0;
                res[index--] = curSum;
            }
        }
        if (carry > 0) {
            res[0] = carry;
            return res;
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }

    public static void main(String[] args) {
        PlusOne sol = new PlusOne();
        System.out.println(Arrays.toString(sol.plusOne(new int[]{9, 9, 9})));
    }
}
