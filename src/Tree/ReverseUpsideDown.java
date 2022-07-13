package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class ReverseUpsideDown {
    public static TreeNode reverse2(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        // unlink existing nodes 否则有环
        root.left = null;
        root.right = null;
        return newRoot;
    }
/**
 * Method 2: iterative
          null
         /
        1 -- null
      /
     2 --  5
   /
 3  -- 4
 // TC: O(n)
 // SC: O(1)
 */
    public static TreeNode reverse(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode prev = null;
        TreeNode prevRight = null;
        while (root != null) {
            TreeNode next = root.left; // record the next node to be processed; temp variable
            TreeNode curRight = root.right; // since root.right will point to prevRight, we must store it in a temp variable
            // reverse
            root.left = prev; // null
            root.right = prevRight; // null
            // record previous
            prev = root; // 1
            prevRight = curRight; // 5
            root = next;
            // unlink
/**        WRONG! This will lose track of the previously reversed nodes
           // prev.left = null;
           // prev.right = null; */
        }
        return prev;
    }
    public static void main(String[] args) {
        String[] arr = {"1","2","5","3","4"};
        TreeNode root = reconstructBT(arr);
        TreeNode reversed = reverse(root);
    }
}
