package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjDuplicatesII {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        // stack is used to store the count of the adjacent duplicate chars
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                stack.offerFirst(1);
                sb.append(s.charAt(i));
            } else {
                int count = stack.pollFirst() + 1;
                if (count == k) {
                    while (count > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                        count--;
                    }
                } else {
                    stack.offerFirst(count);
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveAdjDuplicatesII sol = new RemoveAdjDuplicatesII();
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3)); // "aa"
    }
}
