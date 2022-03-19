package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.val == two.val) {
            return true;
        }
        return helper(one.left, two.right) && helper(one.right, two.left);
    }

    public static void main(String[] args) {
/**
              3
          /       \
         4         4
      /   \       /   \
     5    null  9     5
 */
        String[] input = {"3", "4", "4", "5", "#", "9", "5"};
        TreeNode root = reconstructBT(input);
        System.out.println(isSymmetric(root));
    }
}
