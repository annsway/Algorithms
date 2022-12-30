package SweepLine;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PointIlluminatedByLamp {
    public static int count(int[][] lamps) {
        Comparator<Boundary> comparator = new Comparator<>(){
            @Override
            public int compare(Boundary a, Boundary b) {
                if (a.num == b.num) {
                    return a.type - b.type;
                }
                return a.num - b.num;
            }
        };
        PriorityQueue<Boundary> minHeap = new PriorityQueue<>(comparator);
        for (int i = 0; i < lamps.length; i++) {
            int index = lamps[i][0], radius = lamps[i][1];
            minHeap.offer(new Boundary(index - radius, -1));
            minHeap.offer(new Boundary(index + radius, 1));
        }
        System.out.println(minHeap);
        int numLightsOn = 0, maxLightsOn = 0, resIdx = 0;
        while (!minHeap.isEmpty()) {
            Boundary cur = minHeap.poll();
            System.out.println(cur.num + " " + cur.type);
            if (cur.type == -1) { // start
                numLightsOn++;
            } else {
                numLightsOn--;
            }
            if (numLightsOn > maxLightsOn) {
                maxLightsOn = numLightsOn;
                resIdx = cur.num;
            }
        }
        return resIdx;
    }

    static class Boundary {
        int num;
        int type; // -1: start; 1: end
        Boundary (int num, int type) {
            this.num = num;
            this.type = type;
        }
    }

    public static void main(String[] args) {
//        int[][] lamps = {{-2, 3}, {2, 3}, {2, 1}}; // 1
        int[][] lamps = {{-2, 1}, {2, 1}}; // -3
        System.out.println(PointIlluminatedByLamp.count(lamps));
    }
}
