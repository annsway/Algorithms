package Simulation;

public class PickCarrots {
    public int pickCarrots(int[][] carrot) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int i = (carrot.length + 1) / 2 - 1;
        int j = (carrot[0].length + 1) / 2 - 1;
        int res = 0;

        boolean[][] visited = new boolean[carrot.length][carrot[0].length];

        while (true) {
            res += carrot[i][j];
            int next_i = -1, next_j = -1;
            int max = -1;
            for (int[] dir : dirs) {
                int temp_i = i + dir[0];
                int temp_j = j + dir[1];
                if (isValid(carrot, temp_i, temp_j, visited)) {
                    int temp_max = carrot[temp_i][temp_j];
                    if (temp_max > max) {
                        max = temp_max;
                        next_i = temp_i;
                        next_j = temp_j;
                    }
                }
            }

            if (max == -1) {
                break;
            }

            // update
            i = next_i;
            j = next_j;
            visited[i][j] = true;
        }

        return res;
    }
    private boolean isValid(int[][] carrot, int i, int j, boolean[][] visited) {
        if (i >= 0 && i < carrot.length && j >= 0 && j < carrot[0].length && !visited[i][j]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PickCarrots sol = new PickCarrots();
        int[][] input = {{5,7,6,3},{2,4,8,12},{3,5,10,7},{4,16,4,17}}; // 83

        System.out.println(sol.pickCarrots(input));
    }
}
