package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumBinaryTree {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int index;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            inOrderMap.put(nums[i], i);
        }
        index = nums.length - 1;
        int[] postOrder = Arrays.copyOf(nums, nums.length);
        Arrays.sort(postOrder); // ascending
        return helper(postOrder, 0, nums.length - 1);
    }
    private TreeNode helper(int[] postOrder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = postOrder[index--];
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postOrder, inOrderMap.get(rootVal) + 1, right);
        root.left = helper(postOrder, left, inOrderMap.get(rootVal) - 1);
        return root;
    }

    public static void main(String[] args) {
        MaximumBinaryTree sol = new MaximumBinaryTree();
//        System.out.println(sol.constructMaximumBinaryTree(new int[]{2,1,6,3}));
        System.out.println(sol.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));

    }
}
