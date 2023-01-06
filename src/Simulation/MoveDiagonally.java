package Simulation;

import java.util.HashSet;
import java.util.Set;

public class MoveDiagonally {
    public static int moveDiagonally(int n, int m, int x1, int y1, int x2, int y2) {
        int dx = 1, dy = 1, res = 0, dirChange = 0;
        Set<String> visited = new HashSet<>();
        while (true) {
            int x = x1 + dx;
            int y = y1 + dy;

            // case 1: at a corner
            if ((x < 0 && y < 0) || (x < 0 && y >= m) || (x >= n && y >= m) || (x >= n && y < 0)) {
                dx = -dx;
                dy = -dy;
                res++;
                System.out.println("x1: " + x1 + ", y1: " + y1 + " res: " + res + " (changed direction)");
                continue;
            } else if (x < 0 || x >= n) { // case 2: x is out of bound
                dx = -dx;
                res++;
                System.out.println("x1: " + x1 + ", y1: " + y1 + " res: " + res + " (changed direction)");
                continue;
            } else if (y < 0 || y >= m) { // case 3: y is out of bound
                dy = -dy;
                res++;
                System.out.println("x1: " + x1 + ", y1: " + y1 + " res: " + res + " (changed direction)");
                continue;
            }

            x1 = x;
            y1 = y;
            res++;
            System.out.println("x1: " + x1 + ", y1: " + y1 + " res: " + res);
            StringBuilder sb = new StringBuilder();
            sb.append(x1).append("#").append(y1).append("#").append(dx).append("#").append(dy);
            String cur = sb.toString();
            // base case
            if (visited.contains(cur)) {
                return -1;
            }
            if (x1 == x2 && y1 == y2) {
                return res;
            }
            visited.add(cur);

        }
    }

    public static void main(String[] args) {
//        System.out.println(MoveDiagonally.moveDiagonally(5, 5, 2, 1, 1, 2)); // 7
        System.out.println(MoveDiagonally.moveDiagonally(5, 3, 2, 0, 3, 2)); // -1
    }
}
