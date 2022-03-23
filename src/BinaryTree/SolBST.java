package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class SolBST {
    public static TreeNode deleteTree(TreeNode root, int target) {
        // corner case
        if (root == null) {
            return root;
        }
        if (root.val == target) { // we want to delete root
            // base case 1: target has no left or right child
            if (root.left == null && root.right == null) {
                return null;
            }
            // base case 2 & 3: target has either left child or right child
            else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            // base case 4: target has both left child and right child
            //   base case 4.1: and the right child has no left child
            else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            }
            //   base case 4.2: and the right child has left child
            else {
                TreeNode smallestOfRightSubtree = smallest(root.right);
                smallestOfRightSubtree.left = root.left;
                smallestOfRightSubtree.right = root.right;
                return smallestOfRightSubtree;
            }
        }
        // if target not found, do recursion
        if (target < root.val) {
            root.left = deleteTree(root.left, target); // 这里返回的是root的子树，而非root本身！
        } else if (target > root.val) {
            root.right = deleteTree(root.right, target);
        }
        return root;

    }

    private static TreeNode smallest(TreeNode root) {
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left; // 保存一个prev，因为需要处理smallest的右子树
        root.left = root.left.right;
        return smallest;
    }

    public static void main(String[] args) {
    /*              7
                 /     \
                3      null
              /   \
             2     5
            / \     / \
           1  null  4  6
    */
        String[] input = {"7", "3", "#", "2", "5", "1", "#", "4", "6"};
        TreeNode root = reconstructBT(input);

        deleteTree(root, 5);
        System.out.println(root);
    }
}
