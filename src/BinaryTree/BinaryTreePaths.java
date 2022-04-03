package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class BinaryTreePaths {
    public String[] binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, sb, res);
        return res.toArray(new String[res.size()]);
    }
    private void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) { // leaf node
            res.add(sb.toString());
//            return; // WRONG!
        }
        sb.append("->");
        dfs(root.left, sb, res);
        dfs(root.right, sb, res);
        sb.setLength(len);
    }
    public static void main(String[] args) {
        // build a tree
        /**     5
              /    \
             2      7
              \    / \
               3  6   8
                       \
                        9
         */
        String[] input = {"5","2","7","#","3","6","8","#","#","#","#","#","9"};
        TreeNode root = reconstructBT(input);
        BinaryTreePaths sol = new BinaryTreePaths();
        System.out.println(Arrays.toString(sol.binaryTreePaths(root)));
    }
}
