package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllParenthesesIII {
    private static final char[] PS = new char[]{'(', ')', '<', '>', '{', '}'};
    public List<String> validParenthesesIII(int l, int m, int n) {
        List<String> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] remain = new int[]{l, l, m, m, n, n};
        int targetLen = l * 2 + m * 2 + n * 2;
        StringBuilder sb = new StringBuilder();
        dfs(remain, stack, sb, targetLen, res);
        return res;
    }
    /**
     * Use a stack to preserve the priority (lower index means lower priority, and higher priority parentheses should surround the lower priority parentheses).
     *     check if is open parentheses
     *     if yes, check if is enclosed by higher priority (or empty) and push into the stack
     *     if no, check if previous one is the corresponding open parentheses and delete the previous open parentheses index from stack
     * */
    private void dfs(int[] remain, Deque<Integer> stack, StringBuilder sb, int targetLen, List<String> res) {
        // base case
        if (sb.length() == targetLen) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            // even index: left part
            // top of stack has a lower priority -> need to be surrounded by higher priority parentheses
            if (i % 2 == 0) {
                // stack.peekFirst() > i 意味着栈顶index对应的括号比当前index对应的括号的 priority 更高
                if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    sb.append(PS[i]);
                    stack.offerFirst(i);
                    remain[i]--;
                    dfs(remain, stack, sb, targetLen, res);
                    sb.deleteCharAt(sb.length() - 1); // 吐出左括号
                    stack.pollFirst(); // 吐出左括号的priority
                    remain[i]++;
                }
            } else { // odd index: right part
                // only update the cur if previous / top of the stack is the corresponding open parentheses
                if (!stack.isEmpty() && stack.peekFirst() == i - 1) {
                    sb.append(PS[i]);
                    stack.pollFirst();
                    remain[i]--;
                    dfs(remain, stack, sb, targetLen, res);
                    sb.deleteCharAt(sb.length() - 1); // 吐出右括号
                    stack.offerFirst(i - 1); // 重新添加左括号的priority
                    remain[i]++;
                }
            }
        }
    }
    public static void main(String[] args) {
        AllParenthesesIII sol = new AllParenthesesIII();
//        System.out.println(sol.validParenthesesIII(3, 1, 0));
//        Expected: [["()()()<>", "()()<()>", "()()<>()", "()<()()>", "()<()>()", "()<>()()", "<()()()>", "<()()>()", "<()>()()", "<>()()()"]]
//        System.out.println(sol.validParenthesesIII(2, 1, 1));
//        Expected: [["()()<>{}", "()(){<>}", "()(){}<>", "()<()>{}", "()<>(){}", "()<>{()}", "()<>{}()", "(){()<>}", "(){()}<>", "(){<()>}", "(){<>()}", "(){<>}()", "(){}()<>", "(){}<()>", "(){}<>()", "<()()>{}", "<()>(){}", "<()>{()}", "<()>{}()", "<>()(){}", "<>(){()}", "<>(){}()", "<>{()()}", "<>{()}()", "<>{}()()", "{()()<>}", "{()()}<>", "{()<()>}", "{()<>()}", "{()<>}()", "{()}()<>", "{()}<()>", "{()}<>()", "{<()()>}", "{<()>()}", "{<()>}()", "{<>()()}", "{<>()}()", "{<>}()()", "{}()()<>", "{}()<()>", "{}()<>()", "{}<()()>", "{}<()>()", "{}<>()()"]]
        System.out.println(sol.validParenthesesIII(1, 1, 0));
//        Expected: [["()<><><><>", "<()><><><>", "<>()<><><>", "<><()><><>", "<><>()<><>", "<><><()><>", "<><><>()<>", "<><><><()>", "<><><><>()"]]

    }
}
