package SweepLine;

import java.util.*;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Boundary> lines = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Boundary a, Boundary b) {
                if (a.index == b.index) {
                    // a. Entering lines: 高的优先级更高
                    if (a.type == -1 && b.type == -1) {
                        return b.height - a.height;
                    } else if (a.type == 1 && b.type == 1) {
                        // b. Exiting lines: 矮的优先级更高
                        return a.height - b.height;
                    }
                    return a.type - b.type;
                }
                return a.index - b.index;
            }
        });
        for (int[] b : buildings) {
            lines.offer(new Boundary(b[0], b[2], -1)); // start
            lines.offer(new Boundary(b[1], b[2], 1)); // end
        }
        PriorityQueue<Integer> heights = new PriorityQueue<>((a, b) -> b - a);
        heights.offer(0);
        List<List<Integer>> res = new ArrayList<>();
        int prevMax = 0;
        while (!lines.isEmpty()) {
            Boundary cur = lines.poll();
            if (cur.type == -1) { // entering
                heights.offer(cur.height);
            } else { // exiting
                heights.remove(cur.height);
            }
            int curMax = heights.peek();
            if (curMax != prevMax) {
                res.add(Arrays.asList(cur.index, curMax));
                prevMax = curMax;
            }
        }
        return res;
    }

    static class Boundary {
        int index;
        int height;
        int type;
        Boundary(int index, int height, int type) {
            this.index = index;
            this.height = height;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        SkylineProblem sol = new SkylineProblem();
//        int[][] buildings = {{0,2,3},{2,5,3}};
//        int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
        int[][] buildings = {{2,9,10},{9,12,15}};
        System.out.println(sol.getSkyline(buildings));

    }
}
