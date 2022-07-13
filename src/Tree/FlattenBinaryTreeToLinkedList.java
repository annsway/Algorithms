package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class FlattenBinaryTreeToLinkedList {
    public TreeNode flatten(TreeNode root) {
        // pre-order recursion
        if (root == null) {
            return root;
        }
        TreeNode right = root.right;
        root.right = flatten(root.left);
        root.left = null;
        if (root.right != null) {
            root.right.right = flatten(right);
        }
        return root;
    }

    public static void main(String[] args) {
    /*              1
                 /     \
                2       5
              /   \      \
             3      4     6    */
        String[] input = {"1","2","5","3","4","#","6"};
        TreeNode root = reconstructBT(input);
        FlattenBinaryTreeToLinkedList sol = new FlattenBinaryTreeToLinkedList();
        System.out.println(sol.flatten(root));
    }
}
