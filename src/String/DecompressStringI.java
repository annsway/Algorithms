package String;

public class DecompressStringI {
    public String decompress(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            int count = cur - '0';
            if (i - 1 >= 0 && count <= 9 && count >= 1) {
                while (count > 0) {
                    sb.append(input.charAt(i - 1));
                    count--;
                }
            } else {
                sb.append(input.charAt(i));
            }
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        DecompressStringI sol = new DecompressStringI();
        System.out.println(sol.decompress("ap2lec3n"));
    }
}
