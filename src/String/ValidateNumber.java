package String;

public class ValidateNumber {
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean seenNumber = false;
        boolean seenSignBeforeE = false;
        boolean seenPoint = false;
        boolean seenE = false;
        boolean seenNumberAfterE = false;
        boolean seenSignAfterE = false;
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') { // skip leading spaces
            i++;
        }

        while (i < n) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!seenE) {
                    seenNumber = true;
                } else {
                    seenNumberAfterE = true;
                }
            } else if (c == '+' || c == '-') {
                if (seenSignBeforeE && !seenE) {
                    return false; // seen sign before e twice: +0-9
                } else if (!seenE) {
                    if (!seenNumber && !seenPoint) {
                        seenSignBeforeE = true;
                    } else {
                        return false;
                    }
                } else if (seenE) {
                    if (seenNumberAfterE) {
                        return false; //"459277e38+"
                    } else {
                        seenSignAfterE = true;
                    }
                }
            } else if (c == '.') {
                if (seenPoint || seenE) {
                    return false; // seen point twice: 9.9e8.1
                } else {
                    seenPoint = true;
                }
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenNumber) {
                    return false; // seen eE twice: 2e9E || not seen number before eE: .e or +e
                } else {
                    seenE = true;
                }
            } else {
                return false;
            }
            i++;
        }

        if (seenE && !seenNumberAfterE) {
            return false; // 3e
        }

        return seenNumber;

    }
    public static void main(String[] args) {
        System.out.println(isNumber("-.7e+0435"));
    }
}
