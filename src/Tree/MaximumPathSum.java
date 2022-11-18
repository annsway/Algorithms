package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class MaximumPathSum {
    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);

        leftMax = leftMax < 0 ? 0 : leftMax; // test case: [3a, -2, null, 3b] // -2 + 3b = 1 > 0, 返回 1
        rightMax = rightMax < 0 ? 0 : rightMax;

        globalMax = Math.max(globalMax, leftMax + rightMax + root.val); // 加上 root.key 保证能联通

        return Math.max(root.val, Math.max(leftMax, rightMax) + root.val);
    }

    public static void main(String[] args) {
            // build a tree
        /**       -10
               /      \
              9        20
                     /    \
                     15    7  */

            String[] input = {"-10", "9", "20", "#", "#", "15", "7"};
            TreeNode root = reconstructBT(input);
            MaximumPathSum sol = new MaximumPathSum();
            System.out.println(sol.maxPathSum(root)); // 42

    }
}
