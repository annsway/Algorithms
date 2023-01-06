package SegmentTree;

public class CountBlocksInRange {
}

class SegmentTree {
    // the array representing the segment tree
    int[] tree;
    // the number of elements in the original array
    int n;

    // constructor to build the segment tree
    public SegmentTree(int[] arr) {
        // get the next power of 2 that is greater than or equal to the size of the array
        n = (int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2)));
        // initialize the array for the segment tree with the next power of 2
        tree = new int[2 * n];
        // copy the elements from the original array to the segment tree array
        for (int i = 0; i < arr.length; i++) {
            tree[n + i] = arr[i];
        }
        // build the segment tree
        build();
    }

    // function to build the segment tree
    private void build() {
        // start from the last internal node and work backwards
        for (int i = n - 1; i > 0; i--) {
            // update the value of the current node with the max of its children
            tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
        }
    }

    // function to query the segment tree for a range
    public boolean query(int l, int r) {
        // initialize the variables for the query
        l += n;
        r += n;
        int min = Integer.MAX_VALUE;
        // loop until we reach the root of the tree
        while (l <= r) {
            // if the left node is within the range, update the min
            if (l % 2 == 1) {
                min = Math.min(min, tree[l]);
                l++;
            }
            // if the right node is within the range, update the min
            if (r % 2 == 0) {
                min = Math.min(min, tree[r]);
                r--;
            }
            // move to the parent nodes
            l /= 2;
            r /= 2;
        }
        // return true if the range is empty (i.e., min is the maximum possible value)
        return min == Integer.MAX_VALUE;
    }

    // function to add an element to the segment tree
    public void add(int index, int value) {
        // update the value at the given index
        index += n;
        tree[index] = value;
// update the values of the parent nodes
        while (index > 1) {
            index /= 2;
            tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] operations = {{1, 2}, {1, 5}, {2, 3, 2}, {2, 3, 3}, {2, 1, 1}, {2, 1, 2}};
        StringBuilder sb = new StringBuilder();
        // create an empty segment tree
        SegmentTree tree = new SegmentTree(new int[0]);
        for (int[] op : operations) {
            if (op[0] == 1) {
                // build a block at coordinate x
                tree.add(op[1], op[1]);
            } else {
                // query for a block of size size at coordinate x
                if (tree.query(op[1], op[1] + op[2] - 1)) {
                    // it is possible to build the block, so append 1 to the result string
                    sb.append("1");
                } else {
                    // it is not possible to build the block, so append 0 to the result string
                    sb.append("0");
                }
            }
        }
        // print the result string
        System.out.println(sb.toString());
    }
}
