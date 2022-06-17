package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        // sort the meetings by start time
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0] < 0 ? -1 : 1);
        // minHeap stores the end time of a meeting
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            if (minHeap.isEmpty()) {
                minHeap.offer(endTime);
            } else {
                if (minHeap.peek() <= startTime) {
                    minHeap.poll();
                }
                minHeap.offer(endTime);
            }
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII sol = new MeetingRoomsII();
        int[][] intervals = {{9,10},{4,9},{4,17}};
        System.out.println(sol.minMeetingRooms(intervals));
    }
}
