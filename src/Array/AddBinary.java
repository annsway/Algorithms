package Array;

public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            sum += carry;
            if (sum % 2 != 0) {
                sb.append(sum % 2);
            } else {
                sb.append('0');
            }
            // update carry
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary sol = new AddBinary();
        System.out.println(sol.addBinary("11", "1"));
    }
}
