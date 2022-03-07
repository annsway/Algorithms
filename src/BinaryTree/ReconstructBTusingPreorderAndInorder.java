package BinaryTree;

import java.util.HashMap;

public class ReconstructBTusingPreorderAndInorder {
    HashMap<Integer, Integer> inOrderMap = new HashMap<>();
    int preOrderIndex = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i); // (value, index)
        }
        return helper(preOrder, 0, inOrder.length - 1);
    }
    private TreeNode helper(int[] preOrder, int leftIO, int rightIO) {
        // base case
        if (leftIO > rightIO) { // WRONG: leftIO >= rightIO
            return null;
        }
        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preOrder, leftIO, inOrderMap.get(rootValue) - 1);
        root.right = helper(preOrder, inOrderMap.get(rootValue) + 1, rightIO);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBTusingPreorderAndInorder sol = new ReconstructBTusingPreorderAndInorder();
        sol.buildTree(new int[]{10, 5, 2, 7, 15, 12, 20}, new int[]{2, 5, 7, 10, 12, 15, 20});
    }
}
/**
 * [3,9,20,15,7]
 * [9,3,15,20,7]
 * */