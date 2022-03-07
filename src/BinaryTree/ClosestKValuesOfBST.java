package BinaryTree;

/**
 * public class TreeNode {
 * public int key;
 * public TreeNode left;
 * public TreeNode right;
 * public TreeNode(int key) {
 * this.key = key;
 * }
 * }
 */

import java.util.*;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

/**
 * Analysis:
 * 1. Transform the BST to in-order sequence (ascending)
 * 2. Sliding window
 */
public class ClosestKValuesOfBST {
//    public static int[] closestKValues1(TreeNode root, double target, int k) {
//        // sanity check
//        if (root == null) {
//            return null;
//        }
//        List<Integer> inOrder = new ArrayList<>();
//        transformInOrder(root, inOrder);
//        if (k >= inOrder.size()) {
//            int[] res = new int[inOrder.size()];
//            for (int b = 0; b < inOrder.size(); b++) {
//                res[b] = inOrder.get(b);
//            }
//            return res;
//        }
//        // i represents the slow pointer to traverse array;
//        // j represents the fast pointer to count the elements already put in
//        int i = 0, j = 0;
//        int[] res = new int[k];
//        while (j < inOrder.size()) {
//            while (j - i < k) {
//                j++;
//            }
//            if (j < inOrder.size() && Math.abs(target - inOrder.get(j)) < Math.abs(inOrder.get(i) - target)) {
//                i++; // 挤走第一个元素
//            }
//            j++;
//        }
//
//        for (int a = 0; a < k && i < inOrder.size(); a++) {
//            res[a] = inOrder.get(i);
//            i++;
//        }
//        return res;
//    }
//
//    private static void transformInOrder(TreeNode root, List<Integer> inOrder) {
//        if (root == null) {
//            return;
//        }
//        transformInOrder(root.left, inOrder);
//        inOrder.add(root.key);
//        transformInOrder(root.right, inOrder);
//    }

/**
 Analysis: Use a queue to simulate in order traversal
 TC = O(n)
 SC = O(k)
 */
    public static int[] closestKValues(TreeNode root, double target, int k) {
        // sanity check
        if (root == null || k == 0) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        inOrder(root, queue, target, k);
        // traverse the queue
        int[] res = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll().key;
        }
        return res;
    }
    private static void inOrder(TreeNode root, Queue<TreeNode> queue, double target, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, queue, target, k);
        if (queue.size() < k) {
            queue.offer(root);
        } else if(queue.size() == k && Math.abs(queue.peek().key - target) > Math.abs(root.key - target)) {
            queue.poll();
            queue.offer(root);
        }
        inOrder(root.right, queue, target, k);
    }
    public static void main(String[] args) {
/**       5
      /     \
     2       11
         /    \
         6     14

 closest number to 4 is 5
 target = 6, k = 2
 index =   0 1 2  3  4
 array[] = 2 5 6 11 14
 res[] = {2, 5}
 */
        String[] input = {"5","2","11","#","#","6","14"};
        TreeNode root = reconstructBT(input);
        System.out.println(Arrays.toString(closestKValues(root, 6, 100)));
    }
}
