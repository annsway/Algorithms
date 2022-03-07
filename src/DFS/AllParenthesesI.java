package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb, res);
        return res;
    }

    private void dfs(int l, int r, StringBuilder sb, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(sb.toString());
            return;
        }
        if (l > 0) {
            sb.append('(');
            dfs(l - 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r > l) {
            sb.append(')');
            dfs(l, r - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        AllParenthesesI sol = new AllParenthesesI();
        System.out.println(sol.validParentheses(3));
    }
}
