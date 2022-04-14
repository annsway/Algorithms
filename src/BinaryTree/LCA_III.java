package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class LCA_III {
    boolean pFound = false;
    boolean qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (root == p) {
            pFound = true;
            return root;
        }
        if (root == q) {
            qFound = true;
            return root;
        }
        return left == null ? right : right == null ? left : root;
    }

    /**
     *        -5
     *      /    \
     *    -2      -1
     *   /      /   \
     * 9     -6     -4
     */
    public static void main(String[] args) {
        LCA_III sol = new LCA_III();
        // Create a binary search tree
        String[] array = {"-5", "-2", "-1", "9", "#", "-6", "-4"};
        TreeNode root = reconstructBT(array);
        // test
        System.out.println(sol.lowestCommonAncestor(root, root.left, root.left.left).val);
    }
}
