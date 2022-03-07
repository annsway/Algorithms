package Dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class GymChairEightDirections {
    public List<Integer> putChair (char[][] gym) {
        List<Integer> list = Arrays.asList(-1, 1);
        int n = gym.length;
        int m = gym[0].length;
        double[][] distanceBoard = new double[n][m];
        double globalMin = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gym[i][j] == 'E') {
                    dijkstra(i, j, gym, n, m, distanceBoard);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (gym[i][j] == 'C') {
                    if (distanceBoard[i][j] < globalMin) {
                        globalMin = distanceBoard[i][j];
                        list.set(0, i);
                        list.set(1, j);
                    }
                }
            }
        }
        return list;
    }

    private void dijkstra(int i, int j, char[][] gym, int n, int m, double[][] distanceBoard) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(i, j, 0));
        boolean[][] expanded = new boolean[n][m];
        // eight directions
        int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1},{-1, -1},{-1, 1},{1, -1},{1, 1}};
        while (!minHeap.isEmpty()) {
            // one node can only be expanded once
            Node cur = minHeap.poll();
            if (expanded[cur.row][cur.col]) {
                continue; // skip the expanded node
            }
            // expand
            expanded[cur.row][cur.col] = true;
            distanceBoard[cur.row][cur.col] += cur.distance;
            // generate
            for (int[] dir : directions) {
                int x = cur.row + dir[0];
                int y = cur.col + dir[1];
                if (x < n && x >= 0 && y < m && y >= 0 && gym[x][y] != 'O' && !expanded[x][y]) {
                    Node neighbor;
                    if (dir[0] == 0 || dir[1] == 0) {
                        neighbor = new Node(x, y, cur.distance + 1);
                    } else {
                        neighbor = new Node(x, y, cur.distance + Math.sqrt(2));
                    }
                    minHeap.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        GymChairEightDirections sol = new GymChairEightDirections();
//        System.out.println(sol.putChair(new char[][]{
//                {'E', 'O', 'C'},
//                {'C', 'E', 'C'},
//                {'C', 'C', 'C'}})); // expected: [1, 0]

        System.out.println(sol.putChair(new char[][]{
                {'C', 'C', 'E', 'O', 'C'}
                , {'C', 'C', 'O', 'C', 'E'}
                , {'C', 'C', 'E', 'E', 'C'}
                , {'C', 'O', 'C', 'E', 'E'}
                , {'C', 'C', 'O', 'C', 'C'}
        })); // 四连通答案:[2, 4] vs 我的八连通：[1, 3]

    }

    static class Node implements Comparable<Node> {
        int row;
        int col;
        double distance;

        Node (int row, int col, double distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node another) {
            if (another == null) {
                return -1;
            }
            if (this.distance == another.distance) {
                return 0;
            }
            return this.distance < another.distance ? -1 : 1;
        }
    }
}
