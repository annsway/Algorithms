package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class IsBalancedBT {
    public static boolean isBalanced(TreeNode root) {
        // sanity check
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {

    /*              7
                 /     \
                3      null
              /   \
             2      5
            / \     / \
           1  null  4  6
    */
        String[] input = {"7","3","#","2","5","1","#","4","6"};
        TreeNode root = reconstructBT(input);
        System.out.println(isBalanced(root));

    }
}
