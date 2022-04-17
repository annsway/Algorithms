package String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int curSum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1; // 1 => +; -1 => -
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                curSum += num * sign;
                i--; // for the next for loop iteration
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '(') {
                stack.offerFirst(curSum);
                stack.offerFirst(sign);
                // reset both sign and curSum
                curSum = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                curSum = curSum * stack.pollFirst(); // pop the sign before the (
                curSum += stack.pollFirst();
            }
        }
        return curSum;
    }

    public static void main(String[] args) {
        BasicCalculator sol = new BasicCalculator();
//        System.out.println(sol.calculate("1 + 1")); // expected: 2
//        System.out.println(sol.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(sol.calculate("21")); // 21
    }
}
