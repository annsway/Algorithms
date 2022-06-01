package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder cur = new StringBuilder();
                while (stack.peekFirst() != '[') {
                    cur.append(stack.pollFirst());
                }
                stack.pollFirst(); // remove '['
                int num = 0;
                int carry = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peekFirst())) {
                    num += Character.getNumericValue(stack.pollFirst()) * carry;
                    carry *= 10;
                    System.out.println("num = "+ num);
                }
                // put the current string back to stack, num times
                for (int k = 0; k < num; k++) {
                    for (int j = cur.length() - 1; j >= 0; j--) {
                        stack.offerFirst(cur.charAt(j));
                    }
                }
            } else {
                stack.offerFirst(c);
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pollFirst();
        }
        return new String(res);
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();
        System.out.println(sol.decodeString("100[lc]"));
    }
}
