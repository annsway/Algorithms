package Bit;

public class ReverseBits {
    public static long reverseBits(long n) {
        int i = 0; // first bit
        int j = 31; // last bit
        while (i < j) {
            // get the bits at position i and position j
            long bi = (n >> i) & 1L;
            long bj = (n >> j) & 1L;
            if (bi != bj) { // swap
                // prepare for the position bits 1 to do XOR operation
                long pos_i = 1L << i;
                long pos_j = 1L << j;
                long pos = pos_i + pos_j;
                // XOR operation
                n = n ^ pos;
            }
            i++;
            j--;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(10));
    }
}
