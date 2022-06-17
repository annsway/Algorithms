package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            if (stack.isEmpty() || stack.peekFirst() * a >= 0) {
                stack.offerFirst(a);
            } else {
                boolean equal = false;
                while (!stack.isEmpty() && stack.peekFirst() * a < 0 && stack.peekFirst() > 0) { // -> <-
                    int top = stack.pollFirst();

                    if (top == a * (-1)) {
                        equal = true;
                        break;
                    } else if (top > a * (-1)) {
                        a = top;
                    }

                }
                if (!equal) {
                    stack.offerFirst(a);
                }
            }
        }
        int[] res = new int[stack.size()];
        int index = res.length - 1;
        while (!stack.isEmpty()) {
            res[index--] = stack.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {-2,-1,1,2};
//        int[] input = {8, -8, 5, -10};
//        int[] input = {5, 10, -5};
        AsteroidCollision sol = new AsteroidCollision();
        System.out.println(Arrays.toString(sol.asteroidCollision(input)));
    }
}
