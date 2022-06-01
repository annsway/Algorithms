package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pollFirst();
            }
            if (stack.isEmpty() || heights[stack.peek()] > heights[i]) {
                stack.offerFirst(i);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 3, 1};
        BuildingsWithOceanView sol = new BuildingsWithOceanView();
        System.out.println(Arrays.toString(sol.findBuildings(input)));
    }
}
