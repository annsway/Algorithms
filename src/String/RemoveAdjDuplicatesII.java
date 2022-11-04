package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjDuplicatesII {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        // stack to store the counts of the adjacent duplicate chars
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i - 1) != sb.charAt(i)) {
                stack.offerFirst(1);
            } else {
                int count = stack.pollFirst() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.offerFirst(count);
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
