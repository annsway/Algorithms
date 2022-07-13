package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class IsCompletedTree {
    public static boolean isCompleted(TreeNode root) {
        // corner case
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>(); // the nodes of each level of the binary tree
        queue.offer(root);
        boolean foundFirstBubble = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                foundFirstBubble = true;
            } else if (foundFirstBubble) {
                return false; // case 2: different root, second missing child appears.
            } else {
                queue.offer(cur.left);
            }

            if (cur.right == null) {
                foundFirstBubble = true;
            } else if (foundFirstBubble) {
                return false; // case 1: under the same root, right child is missing.
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
/**               5
             /       \
            3         8
          /   \       /   \
         2     null  null  9
         */
        String[] input = {"5", "3", "8", "2", "#", "#", "9"};
        TreeNode root = reconstructBT(input);
        System.out.println(isCompleted(root));
    }

}
