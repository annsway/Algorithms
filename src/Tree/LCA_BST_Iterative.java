package Tree;

import static Tree.CreateBSTusingLevelOrder.reconstructBST;

public class LCA_BST_Iterative {
    public static TreeNode lca(TreeNode root, int p, int q) {
        // preprocessing to reduce TC
        int small = Math.min(p, q);
        int large = Math.max(p, q);
        while (root != null) {
            if (root.val < small) {
                root = root.right;
            } else if (root.val > large) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         *        5
         *      /   \
         *     2     12
         *    / \     \
         *  1   3     14
         **/
        String[] array = {"5", "2", "12", "1", "3", "#", "14"};

        TreeNode root = reconstructBST(array);
        TreeNode LCA = lca(root, 1, 2);
        System.out.println(LCA.val);
    }
}
