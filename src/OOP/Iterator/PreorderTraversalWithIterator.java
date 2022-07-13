package OOP.Iterator;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class PreorderTraversalWithIterator implements Iterator<TreeNode> {
    Deque<TreeNode> stack;

    // constructor
    public PreorderTraversalWithIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        if (root != null) {
            stack.offerFirst(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    @Override
    public TreeNode next() {
        if (hasNext()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            return cur;
        }
        return null;
    }

    public static void main(String[] args) {
        // build a tree
    /**         5
     *      /     \
           2       11
                 /    \
                 6     14  */
        String[] input = {"5","2","11","#","#","6","14"};
        TreeNode root = reconstructBT(input);
        PreorderTraversalWithIterator iterator = new PreorderTraversalWithIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().val);
        }

    }
}
