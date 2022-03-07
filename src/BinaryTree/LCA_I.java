package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class LCA_I {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // sanity check
        if (root == null) {
            return root;
        }
        // base case
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        // case 1: node A and node B share the same parent node
        if (left != null && right != null) {
            return root;
        }
        // case 2: node A is a parent node B
        return left == null ? right : left;
    }

    /**
     * -5
     * /    \
     * -2      -1
     * /    /    \
     * 9    -6     -4
     **/
    public static void main(String[] args) {
        // Create a binary search tree
        String[] array = {"-5", "-2", "-1", "9", "#", "-6", "-4"};
        TreeNode root = reconstructBT(array);
        // test
        System.out.println(lowestCommonAncestor(root, root.left, root.left.left).key);
    }

}
