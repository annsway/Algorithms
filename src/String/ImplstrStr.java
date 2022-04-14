package String;

public class ImplstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
//            System.out.println(haystack.charAt(i));
//            System.out.println(needle.charAt(0));
            if (haystack.charAt(i) == needle.charAt(0) && i + needle.length() - 1 < haystack.length()) {
                int j = 0;
                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplstrStr sol = new ImplstrStr();
        System.out.println(sol.strStr("mississippi","issip"));
    }
}
