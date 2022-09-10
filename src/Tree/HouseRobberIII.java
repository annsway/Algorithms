package Tree;

import java.util.HashMap;
import java.util.Map;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class HouseRobberIII {
    Map<TreeNode, Integer> robResults;
    Map<TreeNode, Integer> notRobResults;

    public int rob(TreeNode root) {
        robResults = new HashMap<>();
        notRobResults = new HashMap<>();
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean parentRobbed) {
        if (root == null) {
            return 0;
        }
        if (parentRobbed) {
            if (notRobResults.containsKey(root)) {
                System.out.println("notRobResults already add: " + root.key);
                return notRobResults.get(root);
            }
            // cannot rob current house
            int curMax = helper(root.left, false) + helper(root.right, false);
            notRobResults.put(root, curMax);
            return curMax;
        } else {
            if (robResults.containsKey(root)) {
                System.out.println("robResults already add: " + root.key);
                return robResults.get(root);
            }
            // 1. rob current house 2. do not rob current house
            int robCur = root.val + helper(root.left, true) + helper(root.right, true);
            int notRobCur = helper(root.left, false) + helper(root.right, false);
            int curMax = Math.max(robCur, notRobCur);
            robResults.put(root, curMax);
            return curMax;
        }
    }

    public static void main(String[] args) {
        // build a tree
    /**       5 v
          /
         2
       /
      1
    /
   4
         */
        String[] input = {"5","2","#","1","#","4"};
        TreeNode root = reconstructBT(input);

        HouseRobberIII sol = new HouseRobberIII();
        System.out.println(sol.rob(root));
    }
}
