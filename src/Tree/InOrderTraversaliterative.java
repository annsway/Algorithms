package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class InOrderTraversaliterative {
    //    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode cur = root;
//        while (!stack.isEmpty() || cur != null) {
//            if (cur != null) {
//                stack.offerFirst(cur);
//                cur = cur.left;
//            } else {
//                cur = stack.pollFirst(); // WRONG! => we're polling and offering the same node over and over again
//                res.add(cur.val);
//                if (cur.right != null) {
//                    cur = cur.right;
//                }
////                TreeNode node = stack.pollFirst(); // root of the current subtree
////                res.add(node.val);
////                if (node.right != null) {
////                    cur = node.right;
////                }
//            }
//        }
//        return res;
//    }
    public List<Integer> inOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                res.add(cur.key);
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    /*              7
                 /     \
                3      2
              /
             9
    */
        InOrderTraversaliterative sol = new InOrderTraversaliterative();
        String[] input = {"7", "3", "2", "9"};
        TreeNode root = reconstructBT(input);
        System.out.println(sol.inOrder(root));

    }
}
