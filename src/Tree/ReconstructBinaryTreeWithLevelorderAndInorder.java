package Tree;

import java.util.*;

public class ReconstructBinaryTreeWithLevelorderAndInorder {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        List<Integer> levelOrderList = new ArrayList<>();
        for (int num : levelOrder) {
            levelOrderList.add(num);
        }
        return helper(levelOrderList, 0, inOrder.length - 1);
    }
    private TreeNode helper(List<Integer> levelOrderList, int leftIO, int rightIO) {
        // base case
        if (leftIO > rightIO) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrderList.remove(0));
        List<Integer> leftSubtree = new ArrayList<>();
        List<Integer> rightSubtree = new ArrayList<>();
        for (int num : levelOrderList) {
            // compare the [indices] of the root node and the current node in the in order traversal
            if (inOrderMap.get(num) < inOrderMap.get(root.val)) {
                leftSubtree.add(num);
            } else {
                rightSubtree.add(num);
            }
        }
        root.left = helper(leftSubtree, leftIO, inOrderMap.get(root.val) - 1);
        root.right = helper(rightSubtree, inOrderMap.get(root.val) + 1, rightIO);
        return root;
    }
}
