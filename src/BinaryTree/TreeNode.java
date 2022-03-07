package BinaryTree;

/* Class containing left and right child of current node and key value*/
public class TreeNode {
    public int key; // declare as public so that classes in other packages (e.g. BFS) can access this field
    public TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}
