package BFS;

import BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class ZigZacLevelOrderTraversal {
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> s = new ArrayDeque<>();
        s.offerFirst(root);
        int layer = 0;

        while (!s.isEmpty()) {
            int curSize = s.size();
            for (int i = 0; i < curSize; i++) {
                if (layer == 0) {
                    TreeNode cur = s.pollLast();
                    res.add(cur.key);
                    if (cur.right != null) {
                        s.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        s.offerFirst(cur.left);
                    }
                } else {
                    TreeNode cur = s.pollFirst();
                    res.add(cur.key);
                    if (cur.left != null) {
                        s.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        s.offerLast(cur.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return res;
    }

    public static void main(String[] args) {
        ZigZacLevelOrderTraversal sol = new ZigZacLevelOrderTraversal();
    /*              3
                 /     \
                9      20
              /  \     / \
             6   10   15  7
    */
        String[] input = {"3","9","20","6", "10", "15", "7"};
        TreeNode root = reconstructBT(input);
        System.out.println(sol.zigZag(root));
    }
}
