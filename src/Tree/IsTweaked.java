package Tree;

import static Tree.CreateBinaryTreeUsingLevelOrder.reconstructBT;
/**
 sub-problems:
 (1) one.left vs two.right && one.right vs two.left, OR
 (2) one.left vs two.left && one.right vs two.right
 case 1: one.left == two.right
      5            5
    /   \        /  \
   3     8      8    3
 / \    / \   / \   / \

 case 2: one.left == two.right
    5            5
  /   \        /  \
 3     8      3    8
 */
public class IsTweaked {
    public static boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        System.out.println("recursive call");
        // sanity check
        if (one == null && two == null) {
            return true;
        }
        if (one == null || two == null || one.val != two.val) {
            return false;
        }
        return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
        || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }
    public static void main(String[] args) {
        String[] arr1 = {"1", "1", "2"};
        String[] arr2 = {"1", "1", "1"}; // eight recursive calls TC = O(n^2) = O(3^2) = 9
/**
 case 1: one.left == two.right
             1               1
           /   \           /    \
          1     2         1      1

 * */
        TreeNode one = reconstructBT(arr1);
        TreeNode two = reconstructBT(arr2);

        System.out.println(isTweakedIdentical(one, two));
    }
}
