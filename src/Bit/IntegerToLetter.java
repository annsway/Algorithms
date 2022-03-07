package Bit;

public class IntegerToLetter {
    public char convert(int i) {
        return (char)('A' + i - 'A');
    }
    public static void main(String[] args) {
        IntegerToLetter sol = new IntegerToLetter();
        System.out.println(sol.convert(70));
    }
}
