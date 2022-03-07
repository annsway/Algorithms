package DFS;

public class PartitionKgroups {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (k == 0 || total % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, total / k, 0, k, visited, 0);
    }

    private static boolean dfs(int[] nums, int target, int curSum, int k, boolean[] visited, int startIdx) {
        // base case
        if (k == 1) {
            return true; // last bucket will for sure be able to partition
        }
        if (curSum == target) {
            // dfs again for the next subset!
            return dfs(nums, target, 0, k - 1, visited, 0); // k - 1
        }
        for (int i = startIdx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, target, curSum + nums[i], k, visited, i + 1)) { // k
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
        System.out.println(canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }
}