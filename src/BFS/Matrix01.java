package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Matrix01 {
    public static int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = mat.length, n = mat[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        // enqueue all the zero cells
        System.out.println("enqueue: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 && !visited[i][j]) {
                    System.out.print(" x = " + i + " y = " + j);
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            System.out.println(" " + size);
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur.x + dir[0];
                    int y = cur.y + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        q.offer(new Pair(x, y));
                        visited[x][y] = true;
                        // System.out.println("x = " + x + " y = " + y);
                        if (mat[x][y] == 1) {
                            mat[x][y] = count;
                        }
                    }
                }
            }
        }
        return mat;
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        System.out.println(Matrix01.updateMatrix(matrix));
    }
}
