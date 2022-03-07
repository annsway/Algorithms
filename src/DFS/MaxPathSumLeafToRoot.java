package DFS;

import BinaryTree.TreeNode;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class MaxPathSumLeafToRoot {
    public static int maxPathSumLeafToRoot(TreeNode root) {
        int[] globalMax = {Integer.MIN_VALUE};
        DFS(root, 0, globalMax);
        return globalMax[0];
    }
    private static void DFS(TreeNode root, int curSum, int[] globalMax) {
        // base case
        if (root == null) {
            return;
        }
        // For each level, pre-order traversal, add the current root.key to the curSum
        curSum += root.key;
        DFS(root.left, curSum, globalMax);
        DFS(root.right, curSum, globalMax);
        if (root.left == null && root.right == null) { // update globalMax[0] only if reaches to leaf node
            globalMax[0] = Math.max(curSum, globalMax[0]);
        }
    }

    public static void main(String[] args) {
       /**  4
          /   \
         -9  -15
        /
      -3       */
       String[] array = {"4","-9","-15","-3"};
       TreeNode root = reconstructBT(array);
        System.out.println(maxPathSumLeafToRoot(root));
    }
}
