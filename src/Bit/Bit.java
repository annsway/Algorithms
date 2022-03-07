package Bit;

public class Bit {
    public int missingNum(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
            System.out.println(xor);
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
//        System.out.println("a = " + a);
//        System.out.println("a + 1 = " + (a + 2));
        int b = a << 1; // overflow: 全部往左一位，补0（？）
//        System.out.println(b);

        int i = 65;
        char c = (char)i;
        System.out.println(c); //output: A
        System.out.println(i); //output: 65
    }
}
