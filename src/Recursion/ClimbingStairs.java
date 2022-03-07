package Recursion;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int path1 = climbStairs(n - 1);
        int path2 = climbStairs(n - 2);
        return path1 + path2;
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(3)); // 5
    }
}
