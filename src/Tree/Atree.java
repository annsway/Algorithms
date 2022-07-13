package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;

public class Atree {
    public static void main(String[] args) {
        // build a tree
    /**       5
           /     \
          2       11
       /    \
      6     14

         */
        String[] input = {"5","2","11","#","#","6","14"};
        TreeNode root = reconstructBT(input);
    }
}
