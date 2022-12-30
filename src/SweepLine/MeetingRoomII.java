package SweepLine;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public static int minMeetingRooms(int[][] intervals) {
        Comparator<Boundary> comparator = new Comparator<>(){
            @Override
            public int compare(Boundary a, Boundary b) {
                if (a.index == b.index) {
                    return a.type - b.type;
                }
                return a.index - b.index;
            }
        };
        PriorityQueue<Boundary> heap = new PriorityQueue<>(comparator);
        for (int[] interval : intervals) {
            heap.offer(new Boundary(interval[0], 1));
            heap.offer(new Boundary(interval[1], -1));
        }
        int meetings = 0, res = 0;
        while (!heap.isEmpty()) {
            meetings += heap.poll().type;
            res = Math.max(meetings, res);
            System.out.println("meetings: " + meetings + " res: " + res);
        }
        return res;
    }

    static class Boundary {
        int index;
        int type; // 1: start; -1: end
        Boundary (int index, int type) {
            this.index = index;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 5}, {5, 10}};
        System.out.println(MeetingRoomII.minMeetingRooms(intervals));
    }
}
