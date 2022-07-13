package Tree;

public class ReconstructBSTfromLevelOrder {
    public TreeNode reconstruct(int[] level) {
        if (level == null || level.length == 0) {
            return null;
        }
        return reconstruct(level, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode reconstruct(int[] level, int index, int lowerBound, int upperBound) {
        TreeNode root = new TreeNode(level[index]);
        for (int i = index + 1; i < level.length; i++) {
            if (level[i] < root.key && root.left == null && level[i] > lowerBound) {
                root.left = reconstruct(level, i, lowerBound, root.key);
            }
            if (level[i] > root.key && root.right == null && level[i] < upperBound) {
                root.right = reconstruct(level, i, root.key, upperBound);
            }
        }
        return root;
    }
    /**
     *             5
     *          /    \
     *         2
     *       /   \
     *      1     3
     * 
     */
    public static void main(String[] args) {
        ReconstructBSTfromLevelOrder sol = new ReconstructBSTfromLevelOrder();
        System.out.println(sol.reconstruct(new int[]{5,2,1,3}));
    }
}
