package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            if (isAlphaNum(s.charAt(left))) {
                left++;
            } else if (isAlphaNum(s.charAt(right))) {
                right--;
            } else if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean isAlphaNum(char c) {
        return (c - 'a' < 0 || c - 'a' >= 26) && !Character.isDigit(c);
    }

    public static void main(String[] args) {
        String s = "0P";
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println(sol.isPalindrome(s));

        System.out.println('z' - 'a');
    }
}
