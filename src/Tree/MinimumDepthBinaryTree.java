package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root);
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) { // leaf node
            return 1;
        }
        return Math.min(helper(root.left), helper(root.right)) + 1;
    }

    public static void main(String[] args) {
        MinimumDepthBinaryTree sol = new MinimumDepthBinaryTree();
        // build a tree
/**          1
           /     \
          2       null
         /  \
        3   null
         */
        String[] input = {"1","2","#","3"};
        TreeNode root = reconstructBT(input);
        System.out.println(sol.minDepth(root));

    }
}
