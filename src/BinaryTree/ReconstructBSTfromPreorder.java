package BinaryTree;

public class ReconstructBSTfromPreorder {
    int i = 0;
    public TreeNode reconstruct(int[] A) {
        return helper(A, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] A, int bound) {
        if (i == A.length || A[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(A[i++]);
        root.left = helper(A, root.val);
        root.right = helper(A, bound);
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
