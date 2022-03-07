package Bit;

public class RangBitwiseAnd {
    public static int rangeBitwiseAnd(int m, int n) {
        int answer = 0;
        for (int bit = 31; bit >= 0; bit--) {
            // case 1: bits are different
            if ((m & (1 << bit)) != (n & (1 << bit))) {
                break; // bit in answer is default to 0
            } else { // case 2: prefix are the same
                answer |= (m & (1 << bit));
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(7,8));
    }
}
/**
 7: 0000 ....0111
 8: 0000 ....1000
 * */
