package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    public boolean isValid(String input) {
        if (input == null || input.length() == 0 || input.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        int pairs = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (map.containsKey(cur)) { // left parenthesis
                stack.offerFirst(cur);
            } else { // right parenthesis
                if (stack.isEmpty() || map.get(stack.peekFirst()) != cur) {
                    return false;
                } else {
                    stack.pollFirst(); // if there's a match, then poll the left parenthsis as it was used up for this time
                    pairs++;
                }
            }
        }
        return pairs == input.length() / 2;
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid("((()))")); // expected: true
        System.out.println(sol.isValid("{{(")); // expected: false
    }
}
