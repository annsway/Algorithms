package BinaryTree;

import java.util.*;

public class VerifyPreorderSerializationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
        // number of available slots
        int slots = 1;

        for(String node : preorder.split(",")) {
            // one node takes one slot
            --slots;

            // no more slots available
            if (slots < 0) return false;

            // non-empty node creates two children slots
            if (!node.equals("#")) slots += 2;
        }

        // all slots should be used up
        return slots == 0;
    }
    public static void main(String[] args) {
        VerifyPreorderSerializationOfBinaryTree sol = new VerifyPreorderSerializationOfBinaryTree();
//        System.out.println(sol.isValidSerialization("9,#,#,1")); // false
        System.out.println(sol.isValidSerialization("1,#"));// false
//        System.out.println(sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));// true
    }
}
/**
          _9_
         /   \
        3     2
      / \    / \
     4   1   #  6
    / \ / \    / \
   #  # # #    # #

 */
