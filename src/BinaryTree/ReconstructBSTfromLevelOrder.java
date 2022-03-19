package BinaryTree;

public class ReconstructBSTfromLevelOrder {
    public TreeNode reconstruct(int[] level) {
        // Write your solution here
        TreeNode root = null;
        for (int i = 0; i < level.length; i++) {
            root = helper(root, level[i]);
        }
        return root;
    }

    private TreeNode helper(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data <= root.val) {
            root.left = helper(root.left, data);
        }
        if (data > root.val) {
            root.right = helper(root.right, data);
        }
        return root;
    }
}
