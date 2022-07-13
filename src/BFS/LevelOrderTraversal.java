package BFS;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class LevelOrderTraversal {
    public static List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // corner case
        if (root == null) {
            return res;
        }
        // base case
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
    public static void main(String[] args) {

    /*              7
                 /     \
                3      null
              /   \
             2      5
            / \     / \
           1  null  4  6
    */
        String[] input = {"7","3","#","2","5","1","#","4","6"};
        TreeNode root = reconstructBT(input);
        System.out.println(layerByLayer(root));
    }
}

