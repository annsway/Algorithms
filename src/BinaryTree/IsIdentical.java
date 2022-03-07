package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class IsIdentical {
    public boolean isIdentical(TreeNode one, TreeNode two) {
        // base case
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        }
        // subproblems
        if (one.key == two.key) {
            return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
/**
           3
      /       \
     4         6
    /   \
   5    9
 */

        IsIdentical sol = new IsIdentical();
        String[] one = {"3", "4", "6", "5", "9"};
        String[] two = {"3", "4", "6", "5", "9"};
        TreeNode root1 = reconstructBT(one);
        TreeNode root2 = reconstructBT(two);
        System.out.println(sol.isIdentical(root1, root2));
    }
}
