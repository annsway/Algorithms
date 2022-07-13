package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class CousinsBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isX = false;
            boolean isY = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.val == x) {
                    isX = true;
                }
                if (cur.val == y) {
                    isY = true;
                }
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x && cur.right.val == y) ||
                            (cur.right.val == x && cur.left.val == y)) {
                        return false; // brother nodes
                    }
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (isX && isY) {
                return true;
            } else if (isX || isY) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CousinsBinaryTree sol = new CousinsBinaryTree();
        // build a tree
   /**         1
            /     \
           2       3
         /  \     /  \
      null  4    null 5

         */
        String[] input = {"1","2","3","#","4","#","5"};
        TreeNode root = reconstructBT(input);
        System.out.println(sol.isCousins(root, 4, 5));
    }
}
