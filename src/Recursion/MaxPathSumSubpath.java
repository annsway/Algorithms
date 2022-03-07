package Recursion;

/**
 * public class TreeNode {
 * public int key;
 * public TreeNode left;
 * public TreeNode right;
 * public TreeNode(int key) {
 * this.key = key;
 * }
 * }
 */

import BinaryTree.TreeNode;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

/**
 1. What to report to parent node?
 - root + Math.max(left, right);
 - update global max, if needed
 */
public class MaxPathSumSubpath {
    public static int maxPathSum(TreeNode root) {
        // sanity check
        if (root == null) {
            return 0;
        }
        int[] globalMax = {Integer.MIN_VALUE};
        helper(root, globalMax);
        return globalMax[0];
    }

    private static int helper(TreeNode root, int[] globalMax) {
        // base case
        if (root == null) {
            return 0;
        }
        int leftMax = helper(root.left, globalMax);
        int rightMax = helper(root.right, globalMax);
        globalMax[0] = Math.max(globalMax[0], Math.max(root.key, root.key + Math.max(leftMax, rightMax)));
        return Math.max(root.key, root.key + Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
/**              3
               /    \
             -2     -3
            /
           1            */
//        String[] array = {"0", "2", "1", "#", "-1", "#", "6"}; // test case 1
//        String[] array = {"35","-9","-40","-60","89","#","71"}; // test case 2

        String[] array = {"0", "-2", "-3","1"};
        TreeNode root = reconstructBT(array);
        System.out.println(maxPathSum(root));
    }
}
