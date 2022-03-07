package Bit;

public class BinaryToHexadecimal {
    public static String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder("0x");
        boolean isLeading = true;
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        // convert the leftmost 4-bit set per iteration
        for (int i = 28; i >= 0; i -= 4) { // 32 bit - 4 = 28
            char cur = base[((number >> i) & 0xF)]; // 0xF = 15 = 0b 0000 ... 1111 in binary
            if (cur != '0' || !isLeading) { // remove leading zeros. test case: input = 15 => 0x0000000F (前面的7个0应该被去掉)
                sb.append(cur);
                isLeading = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(15 == 0xf); // true
        System.out.println(hex(15)); // 0xF
    }
}
// TC: O(1)
// SC: O(1)

