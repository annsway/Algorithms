package BinaryTree;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class IsBST {
    public static boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }
//    public static boolean isBST(TreeNode root) {
//        // sanity check
//        if (root == null) {
//            return true;
//        }
//        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//    private static boolean isBST(TreeNode root, int min, int max) {
//        // base case
//        if (root == null) {
//            return true;
//        }
//        /**
//         * root.key: the current node of the current layer of the recursion
//         * case 1: root.key >= max
//         * - in the left subtree, there is a node's value greater than the current root's value
//         * - => conflict with the definition: for every node, all the values of its left subtree are smaller than its value.
//         *
//         * case 2: root.key <= min
//         * - in the right subtree, there is a node's value smaller than the current root's value
//         * - => conflicts with the definition: for every node, all the values of its right subtree are greater than its value.
//         * * */
//        // case 1: when
//        if (root.key >= max || root.key <= min) { // 反面：root.key > min && root.key < max ==> true
//            return false;
//        }
//        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
//    }
    public static void main(String[] args) {

    /*              7
                 /     \
                3      2
              /
             9
    */
        String[] input = {"7","3","2","9"};
        TreeNode root = reconstructBT(input);
        System.out.println(isBST(root));

    }
}
