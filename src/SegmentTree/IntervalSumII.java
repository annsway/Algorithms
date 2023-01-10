package SegmentTree;

public class IntervalSumII {
    /* you may need to use some attributes here */

    /*
     * @param A: An integer array
     */
    TreeNode root;
    SegmentTree st;
    public IntervalSumII(int[] arr) {
        // do intialization if necessary
        st = new SegmentTree(arr, 0, arr.length - 1);
        root = st.root;
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return st.query(root, start, end);
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        st.modify(root, index, value);
    }

    static class TreeNode {
        int start, end; // interval [start, end]
        TreeNode left, right; // children
        int intervalSum;
        TreeNode (int start, int end, int intervalSum) {
            this.start = start;
            this.end = end;
            this.intervalSum = intervalSum;
            this.left = null;
            this.right = null;
        }
    }

    static class SegmentTree {
        TreeNode root;
        SegmentTree(int[] nums, int start, int end) {
            this.root = build(nums, start, end);
        }

        TreeNode build(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode node = new TreeNode(start, end, 0);
            if (start < end) {
                int mid = start + (end - start) / 2;
                node.left = build(nums, start, mid); // [start, mid]
                node.right = build(nums, mid + 1, end); // [mid + 1, end]
                if (node.left != null) {
                    node.intervalSum += node.left.intervalSum;
                }
                if (node.right != null) {
                    node.intervalSum += node.right.intervalSum;
                }
            } else { // leaf node
                node.intervalSum = nums[start]; // start = end
            }
            return node;
        }

        void modify(TreeNode root, int index, int value) {
            // find the lead node to modify
            if (root.start == index && root.end == index) {
                root.intervalSum = value;
                return;
            }
            int mid = root.start + (root.end - root.start) / 2;
            if (root.start <= index && index <= mid) {
                modify(root.left, index, value);
            } else if (mid < index && index <= root.end) {
                modify(root.right, index, value);
            }
            root.intervalSum = root.left.intervalSum + root.right.intervalSum;
        }

        long query(TreeNode root, int start, int end) {
            if (root.start == start && root.end == end) {
                return root.intervalSum;
            }
            int mid = root.start + (root.end - root.start) / 2;
//            System.out.println("root.start: " + root.start + " root.end: " + root.end + " mid: " + mid);
            if (end <= mid) {
                return query(root.left, start, end);
            } else if (start >= mid + 1) {
                return query(root.right, start, end);
            } else {
                return query(root.left, start, mid) + query(root.right, mid + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        IntervalSumII sol = new IntervalSumII(new int[]{1, 2, 7, 8, 5});
        System.out.println(sol.query(0, 2));

        sol.modify(0, 4);
        System.out.println(sol.query(0, 1));

        sol.modify(2, 1);
        System.out.println(sol.query(2, 4));
    }
}
