package DFS;

import Tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class BinaryTreePathSumToTargetSubpath {
//    public static boolean exist(TreeNode root, int target) {
//        // sanity check
//        if (root == null) {
//            return false;
//        }
//        Set<Integer> prefixSums = new HashSet<>();
//        /** Q: Why add 0 to the initial set?
//         * A: test case: {"1"}, target = 1 */
//        prefixSums.add(0); // test case: {"1"}, target = 1
//
//        return DFS(root, prefixSums, 0, target);
//    }
//
//    private static boolean DFS(TreeNode root, Set<Integer> prefixSums, int curPrefixSum, int target) {
//        curPrefixSum += root.key; // pre-order traversal - traverse root first
//        // base case
//        if (prefixSums.contains(curPrefixSum - target)) {
//            return true;
//        }
//        // 吃
//        boolean needRemove = prefixSums.add(curPrefixSum);
//        /** Q: why use a flag?
//        A: needRemove == true, meaning the curPrefixSum has been successfully added to the set prefixSums{} for the current recursion layer.
//           Thus, it must be removed (吐) when popping to the previous stack. */
//        if (root.left != null && DFS(root.left, prefixSums, curPrefixSum, target)) {
//            //return DFS(root.left, prefixSums, curPrefixSum, target); // WRONG!
//            /**
//             * Q: 为什么 recursive call 会写在 if condition 里面？
//             * A: 假设不写在if condition 里面，那么在从左子树的最左边第一次弹栈时，直接return false
//             *   给caller了(只走了最左边那一条path)，根本就不会run下面关于右子树的code。
//             *   test case: {"3","-8","9","4","10","2","-5","1","-2"}; // target = 7 (true)
//             *
//             * Q: 什么情况下才会进入这个if 里面？
//             * A: 当在某个子树中找到了solution，base case 会return true 给上一层stack，层层传递true，最后给caller。
//             *    test case: {"3","-8","9","4","10","2","-5","1","-2"}, target = -3 (true)
//             * */
//            System.out.println(prefixSums);
//            return true;
//        }
//        if (root.right != null && DFS(root.right, prefixSums, curPrefixSum, target)) {
//            return true;
//        }
//        // 吐
//        if (needRemove) {
////            prefixSums.remove(prefixSums.size() - 1); // WRONG! boolean remove(Object o) -- need to pass in an Object, not index!
//            prefixSums.remove(curPrefixSum);
//            /**Q: Why remove curPrefixSum?
//             * A: curPrefixSum is the prefix sum at the current layer of the recursion.
//             *    The curPrefixSum needs to be added to the set to count into the historical prefix sum.
//             *    After we traversed the whole subtree, there is no such a solution, we must remove (吐)
//             *    the curPrefixSum.
//             * test case: {"3","-8","9","4","10","2","-5","1","-2"}; // target = 6 (false)
//             * */
//        }
////        System.out.println(prefixSums);
//        return false;
//    }
    Set<Integer> prefixSums;
    int prefixSum = 0;

    public boolean exist(TreeNode root, int target) {
        prefixSums = new HashSet<>();
        prefixSums.add(0);
        return dfs(root, target);
    }

    private boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (prefixSums.contains(prefixSum - target)) {
            return true;
        }
        prefixSum += root.val;
        prefixSums.add(prefixSum);
        return dfs(root.left, target) || dfs(root.right, target);
    }
    public static void main(String[] args) {
/**         5
         /     \
         2      11
              /    \
             6     14
             /
             3           */
//        String[] array = {"3","-8","9","4","10","2","-5","1","-2"}; // target = 6 (false); 7 (true); -3 (true)
        BinaryTreePathSumToTargetSubpath sol = new BinaryTreePathSumToTargetSubpath();
//        String[] array = {"1", "0", "2"}; // target = 3
        String[] array = {"5", "2", "11", "#", "#", "6", "14", "3"}; // target = 17
        TreeNode root = reconstructBT(array);
        System.out.println(sol.exist(root, 17));

    }
}
// TC: O(n) // pre-order traverse the whole binary tree
// SC: O(height)
