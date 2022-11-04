package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjDuplicatesI {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c)
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();


        for(char c : stack) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAdjDuplicatesI sol = new RemoveAdjDuplicatesI();
        System.out.println(sol.removeDuplicates("abbaca")); // "ca"
    }
}
