package Bit;

public class PowerOfTwo {
//    public static boolean isPowerOfTwo(int number) {
//
//    }

    public static void main(String[] args) {
        short a = -1;
        char b = (char) a; // b is unsigned
        int c = (int) b;
        System.out.println("c = " + c); // 65535
        int c2 = (int) a;
        System.out.println("c2 = " + c2); // -1
    }
}
