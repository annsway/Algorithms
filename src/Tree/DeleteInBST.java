package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class DeleteInBST {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        // base case
        if (root.key == key) {
            // case 1: no child
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode smallestRight = findSmallestRight(root.right);
                smallestRight.left = root.left;
                smallestRight.right = root.right;
                return smallestRight;
            }
        }

        if (root.key < key) {
            root.right = deleteTree(root.right, key);
        } else if (root.key > key) {
            root.left = deleteTree(root.left, key);
        }

        System.out.println(root.key);
        return root;
    }
    private TreeNode findSmallestRight(TreeNode root) {
        // 保存一个prev，因为需要处理smallest的右子树
        while (root.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left;
        // override root.left ref
        root.left = root.left.right;
        return smallest;
    }

    public static void main(String[] args) {
        // build a tree
      /**      4
             /    \
             2       6
          /   \    / \
         1     3  5   9          */
        String[] input = {"4","2","6","1","3","5","9"};
        TreeNode root = reconstructBT(input);

        DeleteInBST sol = new DeleteInBST();
        System.out.println(sol.deleteTree(root, 2).key);
    }
}
