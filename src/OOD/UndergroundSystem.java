package OOD;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    private Map<Integer, Event> arrivals;
    private Map<String, Average> averages;

    public UndergroundSystem() {
        arrivals = new HashMap<>();
        averages = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Event cust = new Event(id, stationName, t);
        arrivals.put(id, cust);
    }

    public void checkOut(int id, String stationName, int t) {
        Event arrivalEvent = arrivals.remove(id);
        String key = arrivalEvent.stationName + ":" + stationName;
        int diff = t - arrivalEvent.t;
        if (averages.get(key) == null) {
            Average avg = new Average(diff, 1);
            averages.put(key, avg);
        } else {
            averages.get(key).updateAverage(diff);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + ":" + endStation;
        return averages.get(key).getAverage();
    }

    static class Event {
        int id;
        String stationName;
        int t;

        public Event(int id, String stationName, int t) {
            this.id = id;
            this.stationName = stationName;
            this.t = t;
        }
    }

    static class Average {
        int total; // total time spent between stations
        int count; // total riders

        public Average(int total, int count) {
            this.total = total;
            this.count = count;
        }

        public void updateAverage(int diff) {
            count++;
            total += diff;
        }

        public double getAverage() {
            return total / count;
        }
    }

    public static void main(String[] args) {
        UndergroundSystem sol = new UndergroundSystem();
    }
}
