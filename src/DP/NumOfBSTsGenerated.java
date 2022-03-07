package DP;

public class NumOfBSTsGenerated {
//    public static int numOfTrees(int n) {
//        int[] M = new int[n + 1];
//        M[0] = 1;
//        for (int k = 1; k <= n; k++) {
//            for (int root = 1; root <= k; root++) {
//                M[k] += M[root - 1] * M[k - root];
//                // for k numbers, root - 1 numbers are before root, k - root after root
//            }
//        }
//        return M[n];
//    }

    public static int numOfTrees(int n) {
        int[] M = new int[n + 1];
        // M[i] represents the number of BSTs can be generated with i nodes
        M[0] = 1; // empty tree is one of the BSTs
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                M[i] += M[k - 1] * M[i - k]; // total number of nodes = (k - 1) + (i - k) = i - 1 (除去root node)
            }
        }
        return M[n];
    }

    public static void main(String[] args) {
        System.out.println(numOfTrees(3));
    }

}
