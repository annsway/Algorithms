package BinaryTree;

public class ReconstructBSTfromPreorder {
    int index = 0;
    public TreeNode reconstruct(int[] pre) {
        return helper(pre, Integer.MAX_VALUE);
    }
    private TreeNode helper(int[] pre, int upperBound) {
        if (index == pre.length || pre[index] > upperBound) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index++]);
        root.left = helper(pre, root.val);
        root.right = helper(pre, upperBound);
        return root;
    }
    /**
     *       5
     *     /    \
     *    3      8
     *  /   \     \
     * 1    4     11
     */

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 8, 11};
        ReconstructBSTfromPreorder sol = new ReconstructBSTfromPreorder();
        System.out.println(sol.reconstruct(arr));
    }
}
