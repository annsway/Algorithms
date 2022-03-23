package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class LCA_III {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // write your solution here
        boolean[] seen = new boolean[2];
        TreeNode candidate = lca(root, one, two, seen);
        if (seen[0] == true && seen[1] == true) {
            return candidate;
        }
        return null;
    }
    public static TreeNode lca(TreeNode root, TreeNode one, TreeNode two, boolean[] seen) {
        // Write your solution here.
        if (root == null) {
            return null;
        }
        TreeNode left = lca(root.left, one, two, seen);
        TreeNode right = lca(root.right, one, two, seen);
        if (root == one || root == two) {
            if (root == one) {
                seen[0] = true;
            } else {
                seen[1] = true;
            }
            return root;
        }
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    /**
     *        -5
     *      /    \
     *    -2      -1
     *   /      /   \
     * 9     -6     -4
     */
    public static void main(String[] args) {
        // Create a binary search tree
        String[] array = {"-5", "-2", "-1", "9", "#", "-6", "-4"};
        TreeNode root = reconstructBT(array);
        // test
        System.out.println(lowestCommonAncestor(root, root.left, root.left.left).val);
    }
}
