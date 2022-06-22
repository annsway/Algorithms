package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TallBuildings {
    /**
     * @param arr: the height of all buildings
     * @return: how many buildings can he see at the location of each building
     */
    public int[] tallBuilding(int[] arr) {
        // Write your code here.
        int[] res = new int[arr.length];
        Arrays.fill(res, 1);
        countBuildings(arr, res, 0, arr.length, 1);
        countBuildings(arr, res, arr.length - 1, -1, -1);
        return res;
    }
    private void countBuildings(int[] arr, int[] res, int start, int end, int delta) {
        Deque<Integer> deStack = new ArrayDeque<>();
        for (int i = start; i != end; i += delta) {
            res[i] += deStack.size();
            while (!deStack.isEmpty() && arr[deStack.peekFirst()] <= arr[i]) {
                deStack.pollFirst();
            }
            deStack.offerFirst(i);
        }
    }

    public static void main(String[] args) {
        TallBuildings sol = new TallBuildings();
        int[] arr = {7, 5, 4, 3, 6};
        System.out.println(Arrays.toString(sol.tallBuilding(arr)));
    }
}
/**
 *   i =  0  1  2  3  4
 * arr = {7, 5, 4, 3, 6}
 * re1 = {1, 2, 3, 4, 5}
 * re2 = {3, 4, 5, 5, 5}

 * stack = [6 5
 *
 *
 * */
