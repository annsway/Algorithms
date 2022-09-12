package Tree;

public class SubtreeWithMaxAverage {
    double maxAvg = Integer.MIN_VALUE;
    TreeNodeN maxNode = null;

    /** return the root of the maximum subtree*/
    public TreeNodeN maxAverageNaryTree(TreeNodeN root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return maxNode;
    }

    /** return the totalSum and nodeCount of the subtree*/
    private double[] helper(TreeNodeN root) {
        if (root == null) {
            return new double[]{0, 0};
        }
        int curTotalSum = root.val;
        int curCount = 1;
        for (TreeNodeN child : root.children) {
            double[] subtree = helper(child);
            curTotalSum += subtree[0];
            curCount += subtree[1];
        }
        int curAvg = curTotalSum / curCount;
        if (curCount > 1 && curAvg > maxAvg) {
            maxNode = root;
            maxAvg = curAvg;
        }
        return new double[]{curTotalSum, curCount};
    }

    public static void main(String[] args) {
        SubtreeWithMaxAverage sol = new SubtreeWithMaxAverage();
        TreeNodeN root = new TreeNodeN(200);

        TreeNodeN node12 = new TreeNodeN(120);
        TreeNodeN node18 = new TreeNodeN(180);

        TreeNodeN node11 = new TreeNodeN(110);
        TreeNodeN node2 = new TreeNodeN(20);
        TreeNodeN node3 = new TreeNodeN(30);

        TreeNodeN node15 = new TreeNodeN(150);
        TreeNodeN node8 = new TreeNodeN(80);

        root.children.add(node12);
        root.children.add(node18);

        node12.children.add(node11);
        node12.children.add(node2);
        node12.children.add(node3);

        node18.children.add(node15);
        node18.children.add(node8);

        System.out.println(sol.maxAverageNaryTree(root).val);
    }

    /**
     * Input:
     * 		    20
     * 	      /   \
     * 	    12     18
     *   /  |  \   / \
     * 11   2   3 15  8
     *
     * Output: 18
     *
     * */
}
