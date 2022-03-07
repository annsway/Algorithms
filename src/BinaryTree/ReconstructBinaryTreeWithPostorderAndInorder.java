package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostorderAndInorder {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int postOrderIndex;
    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        postOrderIndex = postOrder.length - 1;
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return helper(postOrder, 0, inOrder.length - 1);
    }
    private TreeNode helper(int[] postOrder, int leftIO, int rightIO) {
        // base csae
        if (leftIO > rightIO) {
            return null;
        }
        int rootValue = postOrder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);
        root.right = helper(postOrder,inOrderMap.get(rootValue) + 1, rightIO);
        root.left = helper(postOrder, leftIO, inOrderMap.get(rootValue) - 1);
        return root;
    }
    public static void main(String[] args) {
        ReconstructBinaryTreeWithPostorderAndInorder sol = new ReconstructBinaryTreeWithPostorderAndInorder();
        sol.reconstruct(new int[]{1, 3, 4, 5, 8, 11}, new int[]{1, 4, 3, 11, 8, 5});
    }
}
/**
 the corresponding binary tree is
         5
      /    \
     3      8
   /  \      \
  1   4      11
 * */