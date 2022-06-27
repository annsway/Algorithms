package Sorting;

import java.util.*;

public class AlertKeyCardNames {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Time>> map = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String key = keyName[i];
            String time = keyTime[i];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Time(time));
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Time>> entry : map.entrySet()) {
            List<Time> list = entry.getValue();
            // sort time
            Collections.sort(list, (o1, o2) -> {
                if (o1.hour == o2.hour) return o1.minute - o2.minute < 0 ? -1 : 1;
                return o1.hour - o2.hour < 0 ? -1 : 1;
            });
            if (isWithinOneHour(list)) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    private boolean isWithinOneHour(List<Time> list) {
        for (int i = 0; i < list.size() - 2; i++) {
            Time start = list.get(i);
            Time end = list.get(i + 2);
            if (start.compareTo(end)) {
                return true;
            }
        }
        return false;
    }

    static class Time {
        int hour;
        int minute;

        public Time(String s) {
            String[] a = s.split(":");
            this.hour = Integer.parseInt(a[0]);
            this.minute = Integer.parseInt(a[1]);
        }

        public boolean compareTo(Time time) {
            if (this.hour == time.hour) {
                return true;
            } else if (this.hour + 1 == time.hour && this.minute >= time.minute) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AlertKeyCardNames sol = new AlertKeyCardNames();
        String[] names = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] times = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        System.out.println(sol.alertNames(names, times));
    }
}
