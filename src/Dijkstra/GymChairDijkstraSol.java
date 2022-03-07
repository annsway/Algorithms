package Dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class GymChairDijkstraSol {
    public List<Integer> putChair(char[][] gym) {
        int rows = gym.length;
        int columns = gym[0].length;
        int[][] distanceField = new int[rows][columns];
        // Perform dijkstra for each equipment and store
        // accumulative distance from each chair cell to all equipment
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (gym[i][j] == 'E') {
                    computeDistanceToEquipment(gym, rows, columns, i, j, distanceField);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> result = Arrays.asList(-1, -1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (gym[i][j] == 'C' && distanceField[i][j] < min) {
                    min = distanceField[i][j];
                    result.set(0, i);
                    result.set(1, j);
                }
            }
        }
        return result;
    }

    // For a equipment located at [row, column], compute shortest distance to it
    // from every 'C' cell in gym matrix
    private void computeDistanceToEquipment(char[][] gym, int rows, int columns, int sourceRow, int sourceColumn, int[][] distanceField) {
        // A min-heap that contains nodes for which we don't know
        // the shortest distance to origin yet. But it contains
        // current, tentative shortest distance for those nodes
        PriorityQueue<Node> unvisited = new PriorityQueue<>();
        boolean[][] visited = new boolean[rows][columns];
        unvisited.offer(new Node(sourceRow, sourceColumn, 0));

        while (!unvisited.isEmpty()) {
            // for each iteration, a node with shortest distance to source node among all
            // unvisited nodes is found. This distance is the shortest distance from source
            // to this node because it's impossible to find a shorter path
            Node current = unvisited.poll();
            int row = current.row;
            int column = current.column;
            int distance = current.distance;
            // For nodes we don't know shortest distance yet (unvisited),
            // we may generate multiple paths to this node with different distance values
            // When the shortest of them is found by min-heap, the rest of these values
            // become useless and we don't want to perform any actions on them
            if (visited[row][column]) {
                continue;
            }
            // top neighbor
            if (row - 1 >= 0 && gym[row - 1][column] != 'O' && !visited[row - 1][column]) {
                unvisited.offer(new Node(row - 1, column, distance + 1));
            }
            // bottom neighbor
            if (row + 1 <= rows - 1 && gym[row + 1][column] != 'O' && !visited[row + 1][column]) {
                unvisited.offer(new Node(row + 1, column, distance + 1));
            }
            // left neighbor
            if (column - 1 >= 0 && gym[row][column - 1] != 'O' && !visited[row][column - 1]) {
                unvisited.offer(new Node(row, column - 1, distance + 1));
            }
            // right neighbor
            if (column + 1 <= columns - 1 && gym[row][column + 1] != 'O' && !visited[row][column + 1]) {
                unvisited.offer(new Node(row, column + 1, distance + 1));
            }
            distanceField[row][column] += distance;
            visited[row][column] = true;
        }
    }

    private static class Node implements Comparable<Node> {
        int row;
        int column;
        int distance;
        Node(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(distance, other.distance);
        }
    }

    public static void main(String[] args) {
        GymChairDijkstraSol sol = new GymChairDijkstraSol();
        System.out.println(sol.putChair(new char[][]{{'E', 'O', 'C'},
                {'C', 'E', 'C'},
                {'C', 'C', 'C'}}));
    }

}
