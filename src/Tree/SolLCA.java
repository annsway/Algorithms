package Tree;

public class SolLCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // sanity check
        if (root == null) {
            return root;
        }
        // base case
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        // case 1: node A and node B share the same parent node
        if (left != null && right != null) {
            return root;
        }
        // case 2: node A is a parent node B
        if (left != null || right != null) {
            return left != null ? left : right;
        }
        return root;
    }

    public static TreeNodeP lowestCommonAncestor(TreeNodeP root, TreeNodeP one, TreeNodeP two) {
        if (root == null) {
            return root;
        }
        TreeNodeP left = lowestCommonAncestor(root.left, one, two);
        TreeNodeP right = lowestCommonAncestor(root.right, one, two);
        // case 1.1: one and two are both null
        if (left == null && right == null) {
            return null;
        }
        // case 1.2: if one side is not null
        else if (left == null || right == null) {
            return left == null ? right : left;
        }
        // case 1.3: both sides are not null
        else {
            return root;
        }

    }

    /**
     * -5
     * /    \
     * -2      -1
     * /    /    \
     * 9    -6     -4
     **/
    public static void main(String[] args) {
        // Create a binary search tree 
        TreeNodeP root = new TreeNodeP(-5, null);

        root.left = new TreeNodeP(-2, root);
        root.left.left = new TreeNodeP(9, root.left);

        root.right = new TreeNodeP(-1, root);
        root.right.right = new TreeNodeP(-4, root.right);
        root.right.left = new TreeNodeP(-6, root.right);

        // test
        lowestCommonAncestor(root, root.left.left, root.right.right);
    }

}
