package String;

public class PrefixPalindrome {
    public static String solvePrefixPalindrome(String s) {
        int max = 0;
        for (int i = 2; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            StringBuilder sb = new StringBuilder(s1);
            String s2 = String.valueOf(sb.reverse());

            if (s2.equals(s1)) {
                if (s2.length() > max)
                    max = s2.length();
            }
        }

        if (max > 1)
            return solvePrefixPalindrome(s.substring(max)); // substring(int beginIndex)
        else
            return s.substring(max);

    }

    public static void main(String[] args) {
//        System.out.println(PrefixPalindrome.solvePrefixPalindrome("codesignal")); // "codesignal"
        System.out.println(PrefixPalindrome.solvePrefixPalindrome("aaacodedoc")); // ""
    }
}