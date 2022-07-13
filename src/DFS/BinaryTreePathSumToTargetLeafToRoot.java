package DFS;

import Tree.TreeNode;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 /**
 [1,2,2,-5,-5,-5,-5],3
 1
 /   \
 2      2
 /  \    /  \
 -5  -5  -5  -5
 */
public class BinaryTreePathSumToTargetLeafToRoot {
    public static boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return DFS(root, 0, target);
    }
    private static boolean DFS(TreeNode root, int curSum, int target) {
        // base case
        if (root == null) {
            return false;
        }
        // pre-order traversal
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == target) {
            return true;
        }
        return DFS(root.left, curSum, target) || DFS(root.right, curSum, target);
    }
/**    1
     /   \
    2      2
  /  \    /  \
 -5  0  -5  -5  */
    public static void main(String[] args) {
        String[] array = {"1","2","2","-5","0","-5","-5"};
        TreeNode root = reconstructBT(array);
        System.out.println(exist(root, 3));
    }
}
// TC: O(n)
// SC: O(height)