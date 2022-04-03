package BinaryTree;

/* Class containing left and right child of current node and key value*/
public class TreeNode {
    public int val; // LeetCode // declare as public so that classes in other packages (e.g. BFS) can access this field
    public int key; // LaiCode
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.key = val;
    }
}
