package BinaryTree;

/* Class containing left and right child of current node and key value*/
public class TreeNode {
    public int val; // declare as public so that classes in other packages (e.g. BFS) can access this field
    public TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}
