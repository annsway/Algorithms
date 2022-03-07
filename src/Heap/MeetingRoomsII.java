package Heap;

import java.util.Arrays;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? 0 : o1[0] < o2[0] ? -1 : 1);
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = intervals[i - 1][1];
            int curStart = intervals[i][0];
            if (prevEnd > curStart) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MeetingRoomsII sol = new MeetingRoomsII();
        int[][] intervals = {{9,10},{4,9},{4,17}};
        System.out.println(sol.minMeetingRooms(intervals));
    }
}
