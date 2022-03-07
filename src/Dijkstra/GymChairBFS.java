package Dijkstra;

import java.util.*;

public class GymChairBFS {
    public List<Integer> putChair(char[][] gym) {
        List<Integer> list = Arrays.asList(-1, -1); // store the index of the best place
        int globalMin = Integer.MAX_VALUE;
        int n = gym.length;
        int m = gym[0].length;
        int[][] distanceBoard = new int[n][m]; // represents
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gym[i][j] == 'E') {
                    BFS(i, j, distanceBoard, gym, n, m);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gym[i][j] == 'C') {
                    if (globalMin > distanceBoard[i][j]) {
                        globalMin = distanceBoard[i][j];
                        list.set(0, i);
                        list.set(1, j);
                    }
                }
            }
        }
        return list;
    }

    private void BFS(int i, int j, int[][] distanceBoard, char[][] gym, int n, int m) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(i, j, 0));
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            distanceBoard[curNode.row][curNode.column] += curNode.distance;
            for (int[] dir : directions) {
                int x = curNode.row + dir[0];
                int y = curNode.column + dir[1];
                if (x < n && x >= 0 && y < m && y >= 0 && gym[x][y] != 'O' && !visited[x][y]) {
                    Node neighbor = new Node(x, y, curNode.distance + 1); // generate
                    q.offer(neighbor);
                    visited[x][y] = true;
                }
            }
        }
    }

    static class Node {
        int row;
        int column;
        int distance;

        Node(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }

    }

    public static void main(String[] args) {
        GymChairBFS sol = new GymChairBFS();
//        System.out.println(sol.putChair(new char[][]{
//                {'E', 'O', 'C'},
//                {'C', 'E', 'C'},
//                {'C', 'C', 'C'}}));

        System.out.println(sol.putChair(new char[][]{{'C', 'C', 'E', 'O', 'C'}
                , {'C', 'C', 'O', 'C', 'E'}
                , {'C', 'C', 'E', 'E', 'C'}
                , {'C', 'O', 'C', 'E', 'E'}
                , {'C', 'C', 'O', 'C', 'C'}
        })); // expected:[2, 4]

    }
}
