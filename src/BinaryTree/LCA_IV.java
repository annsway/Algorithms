package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class LCA_IV {
    public static TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // sanity check
        if (root == null) {
            return root;
        }
        // pre-processing 
        Set<TreeNode> set = new HashSet<>(nodes); // TC = O(1) * k; SC = O(k)
        return LCA(root, set);
    }
    private static TreeNode LCA(TreeNode root, Set<TreeNode> set) {
        // base case
        if (root == null) {
            return root;
        }
        TreeNode left = LCA(root.left, set);
        TreeNode right = LCA(root.right, set);
        if (set.contains(root)) { // TC = O(1) -- set
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    /**
     *        -5
     *      /    \
     *    -2      -1
     *   /      /   \
     * 9     -6     -4
     */
    public static void main(String[] args) {
        // Create a binary search tree
        String[] array = {"-5", "-2", "-1", "9", "#", "-6", "-4"};
        TreeNode root = reconstructBT(array);
        List<TreeNode> set = new ArrayList<>();
        set.add(root.left);
        set.add(root.right);
        // test
        System.out.println(lowestCommonAncestor(root, set).key);
    }
}
