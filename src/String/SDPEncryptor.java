package String;

public class SDPEncryptor {
    private String calculate(String s, Integer a1, Integer a2) {
        char[] dict = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' <= 25) {
                int idx = ((c - 'a') * a1 + a2) % 36;
                char cNew = dict[idx];
                if (!Character.isDigit(cNew)) {
                    sb.append(Character.toUpperCase(cNew));
                } else {
                    sb.append(cNew);
                }
            } else if (c - 'A' >= 0 && c - 'A' <= 25) {
                int idx = ((c - 'A') * a1 + a2) % 36;
                char cNew = dict[idx];
                if (!Character.isDigit(cNew)) {
                    sb.append(Character.toLowerCase(cNew));
                } else {
                    sb.append(cNew);
                }
            } else if (Character.isDigit(c)) {
                int idx = (c * a1 + a2) % 36;
                char cNew = dict[idx];
                sb.append(cNew);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SDPEncryptor sol = new SDPEncryptor();
//        String s = "Cat & 5 DogS";
//        System.out.println(sol.calculate(s, 5, 3));

        System.out.println('5' - '0' + 26);
    }
}
