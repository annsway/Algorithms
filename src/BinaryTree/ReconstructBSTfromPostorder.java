package BinaryTree;

public class ReconstructBSTfromPostorder {
    int index = 0;
    public TreeNode reconstruct(int[] post) {
        index = post.length - 1;
        return helper(post, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int lowerBound) {
        if (index < 0 || post[index] < lowerBound) {
            return null;
        }
        TreeNode root = new TreeNode(post[index--]);
        root.right = helper(post, root.val);
        root.left = helper(post, lowerBound);
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
        int[] arr = {1, 4, 3, 11, 8, 5};
        ReconstructBSTfromPostorder sol = new ReconstructBSTfromPostorder();
        System.out.println(sol.reconstruct(arr));
    }
}
