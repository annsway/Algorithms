package String;

public class ConvertStringToDecimal {
    public static int convert(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + (str.charAt(i) - '0');
        }
        return res;
    }

    /**
     * Step 1: get the rightmost digit by num % 10
     * Step 2:
     *
     * */
    public static String convertToString(int num) {
        StringBuilder sb = new StringBuilder();
        while (num / 10 > 0) {
            sb.append(num % 10);
            num /= 10;
        }
        sb.append(num).reverse();
        return sb.toString();
    }

    public static int atoi(String str) {
        // Write your solution here
        if (str == null || str.length() == 0) { // corner case 1
            return 0;
        }
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') { // corncer case 2: avoid leading spaces
            i++;
        }
        boolean positive = true;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) { // corner case 3
            positive = (str.charAt(i) == '+');
            i++;
        }
        long sum = 0; // corner case 5: avoid integer overflow
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') { // corner case 4: avoid spaces and other characters
            sum = sum * 10 + (str.charAt(i) - '0');
            if (positive && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!positive && -sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        sum = positive ? sum : -sum;
        return (int)sum;
    }

    public static void main(String[] args) {
//        System.out.println(convert("1910"));
//        System.out.println(convertToString(1910));
        System.out.println(atoi("-6147483648"));
    }
}




