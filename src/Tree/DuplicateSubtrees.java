package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class DuplicateSubtrees {
    // We perform postorder traversal, serializing and hashing the serials of subtrees in the process.
    // We can recognize a duplicate subtree by its serialization.
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> res = new LinkedList<>();
//        postorder(root, new HashMap<>(), res);
//        return res;
//    }
//
//    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
//        if (cur == null) return "#";
//        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
//        map.put(serial, map.getOrDefault(serial, 0) + 1);
//        if (map.get(serial) == 2) res.add(cur);
//        return serial;
//    }

    int curId = 1;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<>();
        Map<Integer, Integer> idToCount = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        postorder(root, serialToId, idToCount, res);
        return res;
    }

    private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
        if (root == null) return 0;
        int leftId = postorder(root.left, serialToId, idToCount, res);
        int rightId = postorder(root.right, serialToId, idToCount, res);
        String curSerial = leftId + "," + root.val + "," + rightId;
        int serialId = serialToId.getOrDefault(curSerial, curId);
        if (serialId == curId) curId++;
        serialToId.put(curSerial, serialId);

        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        if (idToCount.get(serialId) == 2) res.add(root);
        return serialId;
    }

    public static void main(String[] args) {
        // build a tree
  /**        1
          /     \
         2        3
      /    \     /  \
     4    null  2   4
               /
              4              */
        String[] input = {"1","2","3","4","#","2","4","#","#","4"};
        TreeNode root = reconstructBT(input);
        DuplicateSubtrees sol = new DuplicateSubtrees();
        System.out.println(sol.findDuplicateSubtrees(root));
    }
}
