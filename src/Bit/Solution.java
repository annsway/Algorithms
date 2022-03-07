package Bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) {
        /** 数据溢出 **/
//        int max = Integer.MAX_VALUE;
//        System.out.println("max = " + max); // max = 2,147,483,647
//        int max_1 = max + 1;
//        System.out.println("max + 1 = " + max_1); // max + 1 = -2,147,483,648
//
//        /** 错位运算 **/
//        // << 运算: 向左错位，右侧补0（最左边的符号位会被错走）
//        int a = 0b1101; // adding 0b in the front to create a binary number
//        int x = a << 1; // x = 00011010
//        System.out.println("a = " + Integer.toBinaryString(a));
//        System.out.println("x = " + Integer.toBinaryString(x));
//
//        // >> 运算 Signed right shit：向右错位，左侧补符号位 1 (最左边的符号位 1 会被保留)
//        int b = 0b10111111;
//        int y = b >> 1; // y = 11011111
//        System.out.println("b = " + Integer.toBinaryString(b));
//        System.out.println("y = " + Integer.toBinaryString(y));
//
//        // >>> 运算 Unsigned right shit：向右错位，左侧补符号位 0 (最左边的符号位被错走)
//        int z = b >>> 1; // c = 01011111
//        System.out.println("z = " + Integer.toBinaryString(z));
//
//        System.out.println(""+'a'+1);
//
//        int[][] test = new int[3][];
//        System.out.println(Arrays.deepToString(test));
//        long t = 20001112221L;
        double[] t = new double[1];
        System.out.println(t[0]); // print: 0.0
    }

}
