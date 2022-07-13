package Tree;

import java.util.*;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

/**
                5
              /    \
            2        8 */
public class PostOrder {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                TreeNode parent = stack.peekFirst();
                if (!visited.contains(parent)) {
                    visited.add(parent);
                    cur = parent.right;
                } else {
                    res.add(parent.key);
                    stack.pollFirst();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    /**
     Example: expected: {1 3 4 2 11 8 5}
                    5
                  /    \
                2        8
              /   \        \
             1     4        11
                  /
                 3
    */
//        String[] input = {"5", "2", "8", "1", "4", "#", "11", "#", "#", "3"};
        String[] input = {"5", "2", "8"};
        TreeNode root = reconstructBT(input);
        PostOrder sol = new PostOrder();
        System.out.println(sol.postOrder(root));

    }
}
