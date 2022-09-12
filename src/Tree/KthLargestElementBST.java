package Tree;

import java.util.ArrayList;
import java.util.List;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class KthLargestElementBST {

    public int kthLargestElementBST(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        int kthLargest = 0, count = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.right == null) { // print right node
                list.add(cur.key);
                count++;
                if (count == k) {
                    return cur.key;
                }
                cur = cur.left;
            } else {
                // find the leftmost leaf node of the *right substree*
                TreeNode pred = findPred(cur);
                if (pred.left == null) {
                    pred.left = cur;
                    cur = cur.right;
                } else {
                    // unlink
                    count++;
                    if (count == k) {
                        return cur.key;
                    }
                    list.add(cur.key);
                    pred.left = null;
                    cur = cur.left; // traverse left subtree
                }
            }
        }
        System.out.println(list);
        return kthLargest;
    }

    private TreeNode findPred(TreeNode root) {
        TreeNode node = root.right;
        while (node.left != null && node.left != root) {
            node = node.left;
        }
        return node;
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

        KthLargestElementBST sol = new KthLargestElementBST();
        System.out.println(sol.kthLargestElementBST(root, 1));
    }
}
