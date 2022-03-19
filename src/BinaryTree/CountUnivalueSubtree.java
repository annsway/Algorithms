package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class CountUnivalueSubtree {
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }
    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    /**       5
           /     \
          1       5
        /    \      \
       5      5      5

         */
        String[] input = {"5","1","5","5","5","#","5"};
        TreeNode root = reconstructBT(input);
        CountUnivalueSubtree sol = new CountUnivalueSubtree();
        System.out.println(sol.countUnivalSubtrees(root));
    }
}
