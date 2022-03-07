package DFS;

public class Test {
    public int minDifference(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] globalDiff = new int[] { Integer.MAX_VALUE };
        int sum = 0;
        for (Integer i : array) {
            sum = sum + i;
        }
        dfsHelper(array, 0, 0, 0, globalDiff, sum);
        return globalDiff[0];
    }

    private void dfsHelper(int[] array, int index, int pickSum, int picks, int[] globalDiff, int total) {
        //base case
        if (index == array.length || picks == array.length / 2) {
            int diff = Math.abs(total - pickSum - pickSum);
            globalDiff[0] = Math.min(globalDiff[0], diff);
            return ;
        }
        //rules
        dfsHelper(array, index + 1, pickSum, picks, globalDiff, total);
        dfsHelper(array, index + 1, pickSum + array[index], picks + 1, globalDiff, total);
    }

    public static void main(String[] args) {
        Test sol = new Test();
        System.out.println(sol.minDifference(new int[] {-2,-9,-3,-1,-1})); // 4
    }
}
