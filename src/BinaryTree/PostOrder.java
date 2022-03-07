package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

/*
 Example: expected: {1 3 4 2 11 8 5}
                5
              /    \
            2        8
          /   \        \
         1     4        11
              /
             3                     */
public class PostOrder {
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    res.add(cur.key);
                }
            } else if (prev == cur.right || prev == cur.left && cur.right == null) {
                stack.pollFirst();
                res.add(cur.key);
            } else {
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }

        return res;
    }

    public static void main(String[] args) {
    /*
     Example: expected: {1 3 4 2 11 8 5}
                    5
                  /    \
                2        8
              /   \        \
             1     4        11
                  /
                 3
    */
        String[] input = {"5", "2", "8", "1", "4", "#", "11", "#", "#", "3"};
        TreeNode root = reconstructBT(input);
        System.out.println(postOrder(root));

    }
}
