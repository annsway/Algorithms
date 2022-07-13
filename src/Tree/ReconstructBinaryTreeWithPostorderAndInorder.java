package Tree;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostorderAndInorder {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] postorder, int leftIO, int rightIO) {
        if (leftIO > rightIO) {
            return null;
        }
        int rootVal = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, inOrderMap.get(rootVal) + 1, rightIO);
        root.left = helper(postorder, leftIO, inOrderMap.get(rootVal) - 1);
        return root;
    }
    public static void main(String[] args) {
        ReconstructBinaryTreeWithPostorderAndInorder sol = new ReconstructBinaryTreeWithPostorderAndInorder();
        sol.buildTree(new int[]{1, 3, 4, 5, 8, 11}, new int[]{1, 4, 3, 11, 8, 5});
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