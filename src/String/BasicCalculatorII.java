package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {
    public int calculate(String s) {
        char sign = '+';
        int curNum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + (c - '0');
            }
            // i == s.length() - 1: to evaluate the last sign
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.offerFirst(curNum);
                } else if (sign == '-') {
                    stack.offerFirst((-1) * curNum);
                } else if (sign == '*') {
                    stack.offerFirst(stack.pollFirst() * curNum);
                } else if (sign == '/') {
                    stack.offerFirst(stack.pollFirst() / curNum);
                }
                curNum = 0;
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculatorII sol = new BasicCalculatorII();
//        System.out.println(sol.calculate("3+2*2"));
        System.out.println(sol.calculate("3+2 "));

    }
}
