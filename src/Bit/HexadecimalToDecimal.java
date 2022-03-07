package Bit;

public class HexadecimalToDecimal {
    public static int convert(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'a' && c <= 'f') {
            return 10 + (c - 'a');
        } else if (c >= 'A' && c <= 'F') {
            return 10 + (c - 'A');
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        System.out.println(convert('A'));
    }
}
