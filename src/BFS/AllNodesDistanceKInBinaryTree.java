package BFS;

import BinaryTree.TreeNode;

import java.util.*;

import static BinaryTree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> chilParentPair;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        chilParentPair = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        List<Integer> ans = new ArrayList();

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                TreeNode node = queue.poll();
                if (dist == K) {
                    ans.add(node.key);
                    for (TreeNode rest : queue) {
                        ans.add(rest.key);
                    }
                    return ans;
                } else {
                    if (node.left != null && !seen.contains(node.left)) {
                        seen.add(node.left);
                        queue.offer(node.left);
                    }
                    if (node.right != null && !seen.contains(node.right)) {
                        seen.add(node.right);
                        queue.offer(node.right);
                    }
                    TreeNode par = chilParentPair.get(node);
                    if (par != null && !seen.contains(par)) {
                        seen.add(par);
                        queue.offer(par);
                    }
                }
                size--;
            }
            dist++;
        }
        return new ArrayList<>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            chilParentPair.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    /**
     *       3
     *    /    \
     *  [5]     1
     * /  \    /  \
     * 6   2   0   8
     *    / \
     *    7  4
     */
    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree sol = new AllNodesDistanceKInBinaryTree();
        // Create a binary search tree
        String[] array = {"3", "5", "1", "6", "2", "0", "8", "#", "#", "7", "4"};
        TreeNode root = reconstructBT(array);
        // test
        System.out.println(sol.distanceK(root, root.left, 2)); // expected: [7, 4, 1]
    }

}
