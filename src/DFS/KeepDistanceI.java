package DFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KeepDistanceI {
    public int[] keepDistance(int k) {
        // Write your solution here.
        int[] res = new int[2*k];
        return backtracking(res, k) ? res : null;
    }
    private boolean backtracking(int[] res, int k) {
        if (k == 0) {
            return true;
        }
        // fill the res[] array; two elements per iteration
        for (int i = 0; i + k + 1 < res.length; i++) {
            if (res[i] == 0 && res[i + k + 1] == 0) {
                res[i] = k;
                res[i + k + 1] = k;
                if (backtracking(res, k - 1)) {
                    return true;
                }
                res[i] = 0;
                res[i + k + 1] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        KeepDistanceI sol = new KeepDistanceI();
        System.out.println(Arrays.toString(sol.keepDistance(4)));
    }
}
