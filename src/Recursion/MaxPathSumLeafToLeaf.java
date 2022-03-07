package Recursion;

import BinaryTree.TreeNode;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class MaxPathSumLeafToLeaf {

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
    public static int maxPathSum(TreeNode root) {
        int[] globalMax = {Integer.MIN_VALUE};
        // corner case
        if (root == null) {
            return globalMax[0];
        }
        maxPathSum(root, globalMax);
        return globalMax[0];
    }

    private static int maxPathSum(TreeNode root, int[] globalMax) {
        // base case
        if (root == null) {
            return 0;
        }
        int leftMax = maxPathSum(root.left, globalMax);
        int rightMax = maxPathSum(root.right, globalMax);
        if (root.left != null && root.right != null) {
            globalMax[0] = Math.max(globalMax[0], leftMax + rightMax + root.key);
            return Math.max(leftMax + root.key, rightMax + root.key);
/** Q: 为什么这里需要return？
 * A: 因为有可能出现左右均有孩子的情况，这里比较大小并 return 最大path sum，会避免left比right小，反而返回left path sum的错误情况。
        -9
        / \
     -60  89     */
        }
//        return Math.max(leftMax, rightMax) + root.key; // WRONG!
        return root.left == null ? rightMax + root.key : leftMax + root.key;
/** Q: 为什么必须要 check if root.left == null ?
 A: case 1: either left child == null or right child == null
 因为base case 这里将null设为0, 如果不check 是否单边为null, 那么会出现 null -> 0, right -> -1, return 0 的错误情况。
 test case: String[] array = {"0", "2", "1", "#", "-1", "#", "6"};
 case 2: both sides are null. 那么随便return 一边的0即可。*/
    }

    public static void main(String[] args) {
/**              35
              /      \
            -9       -40
           / \      /  \
         -60  89   #    71
 */
//        String[] array = {"0", "2", "1", "#", "-1", "#", "6"}; // test case 1
//        String[] array = {"35","-9","-40","-60","89","#","71"}; // test case 2

        String[] array = {"-1", "-2", "-3"};
        TreeNode root = reconstructBT(array);
        System.out.println(maxPathSum(root));
//        int sum = 89 - 9 + 35 - 40 + 71;
//        System.out.println(sum);
    }
}
