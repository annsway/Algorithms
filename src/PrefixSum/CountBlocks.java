package PrefixSum;

public class CountBlocks {
//    public String countBlocks(int[][] input) {
//        StringBuilder sb = new StringBuilder();
//        int[] prefixSum = new int[999];
//
//        for (int[] ops : input) {
//            if (ops[0] == 1) {
//                int block_i = ops[1];
//                for (int i = block_i; i < prefixSum.length; i++) {
//                    prefixSum[i]++;
//                }
//            } else {
//                int start = ops[1], end = ops[1] + ops[2] - 1;
////                System.out.println("start: " + start + " end: " + end);
//                if (prefixSum[end] - prefixSum[start] == 0) {
//                    sb.append(1);
//                } else {
//                    sb.append(0);
//                }
//            }
//        }
//
//        return sb.toString();
//    }

    static class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 1];
        }

        void update(int i, int delta) {
            while (i <= size) {
                tree[i] += delta;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public String countBlocks(int[][] operations) {
        int maxCoordinate = 5;
        FenwickTree tree = new FenwickTree(maxCoordinate);

        StringBuilder output = new StringBuilder();
        for (int[] op : operations) {
            if (op[0] == 1) {
                tree.update(op[1], 1);
            } else {
                int x = op[1];
                int size = op[2];
                int sum = tree.query(x + size - 1) - tree.query(x - 1);
                output.append(sum == 0 ? '1' : '0');
            }
        }
        return output.toString();
    }



    public static void main(String[] args) {
        CountBlocks sol = new CountBlocks();
        int[][] input = new int[][]{{1, 2}, {1, 5}, {2, 3, 2}, {2, 3, 3}, {2, 1, 1}, {2, 1, 2}};
        System.out.println(sol.countBlocks(input)); // expected: 1010

    }

}
