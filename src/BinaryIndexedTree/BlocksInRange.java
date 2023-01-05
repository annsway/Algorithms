package BinaryIndexedTree;

public class BlocksInRange {
    static class BIT {
        long[] psTree;
        int size; // size is the input length, psTree's length is size + 1
        int offset;

        BIT(int size, int offset) {
            this.psTree = new long[size];
            this.size = size;
            this.offset = offset;
        }

        void init(int i, int delta) {
            i += this.offset;
            while (i < psTree.length) {
                psTree[i] += delta;
                i += lowbit(i);
            }
        }

        int lowbit(int x) {
            return x & (-x);
        }

        int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += psTree[i];
                i -= lowbit(i);
            }
            return res;
        }
    }
    public String count(int[][] operations) {
        StringBuilder sb = new StringBuilder();
        // create an empty binary indexed tree

//        System.out.println(2 * (int)Math.pow(10,9));
        BIT bit = new BIT( 47483647,0);

        for (int[] op : operations) {
            if (op[0] == 1) {
                // put a block (val=1) at index op[1]
                bit.init(op[1], 1);
            } else {
                int left = op[1];
                int right = left + op[2] - 1;
                int sum = bit.sum(right) - bit.sum(left);
                sb.append(sum == 0 ? '1' : '0');
            }
        }
        // print the result string
        return sb.toString();
    }
    public static void main(String[] args) {
        int[][] operations = {{1, 2}, {1, 5}, {2, 3, 2}, {2, 3, 3}, {2, 1, 1}, {2, 1, 2}};

//        int[][] operations = {{1, 2}, {1, 5}, {1, -6}, {2, -6, 1}, {2, -5, 3}};

        BlocksInRange sol = new BlocksInRange();
        System.out.println(sol.count(operations));
    }
}
