package Recursion;

public class PrintStringReversed {
    public void printStringReversed (String s) {
        helper(0, s.toCharArray());
    }
    private void helper(int index, char[] array) {
        // base case
        if (index == array.length) {
            return;
        }
        helper(index + 1, array);
        System.out.println(array[index]);
    }

    public static void main(String[] args) {
        PrintStringReversed sol = new PrintStringReversed();
        sol.printStringReversed("abcde");
    }
}
