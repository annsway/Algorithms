package DFS;

public class MinDiffBetweenTwoSubsets {
    private static int cnt = 0;

    public static int minDifference(int[] array) {
        // Write your solution here
        int[] globalMin = new int[1];
        int total = 0;
        for (int num : array) {
            total += num;
        }
        globalMin[0] = Integer.MAX_VALUE;
        dfs(array, globalMin, 0, 0, total, 0);
        return globalMin[0];
    }

    private static void dfs(int[] array, int[] globalMin, int level, int curSum, int total, int count) {
        System.out.println(++cnt);
        // base case
        if (level == array.length) {
            if (count == array.length / 2) {
                globalMin[0] = Math.min(globalMin[0], Math.abs(curSum - (total - curSum)));
            }
            return;
        }
        curSum += array[level];
        dfs(array, globalMin, level + 1, curSum, total, ++count);
        curSum -= array[level];
        dfs(array, globalMin, level + 1, curSum, total, --count);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(minDifference(array));
    }
}
