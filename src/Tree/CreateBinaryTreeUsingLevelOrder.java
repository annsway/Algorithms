package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CreateBinaryTreeUsingLevelOrder {

    // A utility function to do inorder traversal of BST
    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // TC: O(n)
    // SC: O(height)
    public static TreeNode reconstructBT(String[] input) {
        List<Integer> list = new ArrayList<>();
        for (String s : input) {
            if ("#".equals(s)) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(s));
            }
        }
        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty() && i < list.size() / 2) {
            int size = queue.size();
            // j represents the number of nodes in the current layer
            // i represents the index of the child's value in the input array
            for (int j = 0; j < size && i < list.size() / 2; j++, i++) { // loop current layer
                // cur node has two children, add both children to the queue
                TreeNode cur = queue.poll();
                int leftChildIndex = i * 2 + 1;
                int rightChildIndex = i * 2 + 2;
                if (leftChildIndex < list.size() && list.get(leftChildIndex) != null) {
                    cur.left = new TreeNode(list.get(leftChildIndex));
                }
                if (rightChildIndex < list.size() && list.get(rightChildIndex) != null) {
                    cur.right = new TreeNode(list.get(rightChildIndex));
                }
                // add left child to the queue
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
//                System.out.print(cur.key + ", ");
            }
//            System.out.println("");
        }
        return root;
    }
    public static TreeNode constructTree(Integer[] array) {
        //construct tree from Integer array BFS
        if (array == null || array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);
        int i = 1;
        while (i < array.length) {
            TreeNode parent = queue.poll();
            if (array[i] == null) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(array[i]);
                queue.add(parent.left);
            }
            i++;
            if (i < array.length) {
                if (array[i] == null) {
                    parent.right = null;
                } else {
                    parent.right = new TreeNode(array[i]);
                    queue.add(parent.right);
                }
                i++;
            }
        }
        return root;
    }
    public static void main(String[] args) {

/**          5
          /     \
         2      11
              /    \
             6     14
            /
           3           */
//        String[] input = {"5","2","11","#","#","6","14","3"};
        String[] input = {"3","-8","9","4","10","2","-5","1","-2"};
        TreeNode root = reconstructBT(input);
        Integer[] input2 = {3,-8,9,4,10,2,-5,1,-2};
        TreeNode root2 = constructTree(input2);
        System.out.println(root2);
    }
}