package Simulation;

import Utility.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BubbleColor {
    public static int[][] explode(int[][] bubbles) {
        int m = bubbles.length, n = bubbles[0].length;
        boolean[][] mark = new boolean[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Pair> q = new ArrayDeque<>();
        // 1. mark eligible cells as true
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int cur = bubbles[i][j];
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && bubbles[x][y] == cur && !mark[x][y]) {
                        count++;
                    }
                }
                if (count >= 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        // 1.2 mark all neighboring cells as true
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int i = cur.getKey(), j = cur.getValue();
            int val = bubbles[i][j];
            mark[i][j] = true;
            for (int[] dir : dirs) {
                int x = cur.getKey() + dir[0];
                int y = cur.getValue() + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && bubbles[x][y] == val && !mark[x][y]) {
                    q.offer(new Pair(x, y));
                }
            }
        }
        // 2. make eligible cells as 0 in the original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j]) {
                    bubbles[i][j] = 0;
                }
            }
        }
        // 3. for each column, move all zeros up
        for (int j = 0; j < n; j++) {
            int left = m - 1, right = 0;
            while (left > right) {
                if (bubbles[left][j] > 0) {
                    left--;
                } else if (bubbles[right][j] == 0) {
                    right++;
                } else {
                    bubbles[left][j] = bubbles[right][j];
                    bubbles[right][j] = 0;
                    left--;
                    right++;
                }
            }
        }
        return bubbles;
    }

    public static void main(String[] args) {
        int[][] bubbles = {
                {3, 1, 2, 1},
                {1, 1, 1, 4},
                {3, 1, 2, 2},
                {3, 1, 3, 4}};

        System.out.println(Arrays.deepToString(BubbleColor.explode(bubbles)));
    }
}
/** Expected:
 [[0, 0, 0, 1],
 [3, 0, 2, 4],
 [3, 0, 2, 2],
 [3, 0, 3, 4]]


 * */