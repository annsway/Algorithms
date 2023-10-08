package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestPath {
    public static int lengthLongestPath(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        // keep the length of every subdir at the same level?
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(0);
        String[] args = input.split("\n");
        for (String s : args) {
            int tabIdxLevel = s.lastIndexOf('\t') + 1;
            System.out.println("last tab index: " + tabIdxLevel);
            int len = s.length() - tabIdxLevel;
            while (stack.size() > tabIdxLevel + 1) {
                stack.pollFirst();
            }
            if (!s.contains(".")) {
                stack.offerFirst(stack.peekFirst() + len + 1);
            } else {
                maxLen = Math.max(maxLen, stack.peekFirst() + len);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
//        System.out.println(LongestPath.lengthLongestPath(input));
//        System.out.println("\thello".lastIndexOf("\t"));
//        System.out.println("\thello".lastIndexOf('\t'));
//        System.out.println("\thello\tworld".lastIndexOf('\t'));
        System.out.println("\t\tfile.ext".lastIndexOf("\t"));
    }
}
