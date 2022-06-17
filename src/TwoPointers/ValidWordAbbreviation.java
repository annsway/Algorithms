package TwoPointers;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() < abbr.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else {
                if (!Character.isDigit(abbr.charAt(j))) {
                    return false;
                } else {
                    int num = 0;
                    while (Character.isDigit(abbr.charAt(j))) {
                        num = abbr.charAt(j) - '0' + num * 10;
                        j++;
                    }
                    while (num > 0) {
                        i++;
                        num--;
                    }
                }
            }
        }
        return i == j;
    }

    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        ValidWordAbbreviation sol = new ValidWordAbbreviation();
        System.out.println(sol.validWordAbbreviation(word, abbr));
    }
}
