package Tree;

import java.util.ArrayList;
import java.util.List;

public class CreateBSTusingLevelOrder {
//    public static TreeNode reconstruct(int[] input) {
//        // corner case
//        if (input.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(input[0]);
//        for (int i = 0; i < input.length; i++) {
//            insert(root, input[i]);
//        }
//        return root;
//    }
//
//    private static TreeNode insert(TreeNode root, int value) {
//        // base case
//        if (root == null) {
//            return new TreeNode(value);
//        }
//        if (value < root.key) {
//            root.left = insert(root.left, value);
//        } else if (value > root.key) {
//            root.right = insert(root.right, value);
//        }
//        return root;
//    }

    // A utility function to do inorder traversal of BST
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static TreeNode reconstructBST(String[] input) {
        if (input.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if ("#".equals(input[i])) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(input[i]));
            }
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(0));
        for (int i = 0; i < list.size(); i++) {
            insert(root, list.get(i));
        }
        return root;
    }

    private static TreeNode insert(TreeNode root, Integer value) {
        // base case
        if (root == null) {
            return new TreeNode(value);
        }
        if (value != null && value < root.val) {
            root.left = insert(root.left, value);
        } else if (value != null && value > root.val) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {

    /*              7
                 /     \
                3      null
              /   \
             2     [5]
            / \     / \
           1  null  4  6
    */
        String[] input = {"7", "3", "#", "2", "5", "1", "#", "4", "6"};
        TreeNode root = reconstructBST(input);
        System.out.println(root);
        inorder(root);
//            int[] array = {5, 2, 1, 3};
//            TreeNode root = reconstruct(array);
//            System.out.println(reconstruct(array));

    }

}
