package String;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n >= 30) {
            return "";
        }
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = build(result);
        }
        return result;
    }

    private String build(String prev) {
        StringBuilder cur = new StringBuilder();
        int j = 0;
        while (j < prev.length()) {
            int count = 0;
            char val = prev.charAt(j);
            while (j < prev.length() && prev.charAt(j) == val) {
                count++;
                j++;
            }
            cur.append(count);
            cur.append(val);
        }
        return cur.toString();
    }

//    public String countAndSay(int n) {
//        if (n <= 0) return "-1";
//        String result = "1";
//
//        for (int i = 1; i < n; i++) {
//            result = build(result);
//        }
//        return result;
//    }
//
//    private String build(String result) {
//        StringBuilder builder = new StringBuilder();
//        int p = 0;
//        while (p < result.length()) {
//            char val = result.charAt(p);
//            int count = 0;
//
//            while (p < result.length() && result.charAt(p) == val) {
//                p++;
//                count++;
//            }
//            builder.append(count);
//            builder.append(val);
//        }
//        return builder.toString();
//    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println(sol.countAndSay(4));
    }
}
