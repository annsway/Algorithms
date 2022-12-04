package OOD.DesignParkingLot;

import DFS.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestPLSolution {
    public void testParkingLot() throws Exception {
        ParkingLot lot = new ParkingLot(4, 10);
        List< Vehicle > list = new ArrayList<>();
        LinkedList cars = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle v = i < 15 ? new Truck() : new Car();
            System.out.println("i: " + i + " v.getSize(): " + v.getSize());
            boolean hasSpot = lot.hasSpot(v);
            if (i >= 40) {
                check(!hasSpot);
            } else {
                check(hasSpot);
                check(lot.park(v));
                cars.add(i);
            }
            list.add(v);
        }
        int i = 0;
        for (Vehicle v : list) {
            if (i >= 40) {
                check(!lot.leave(v));
            } else {
                check(lot.leave(v));
                cars.removeFirst();
                check(!lot.leave(v));
            }
            i++;
        }
    }
    public void check(boolean pass) {
        if (!pass) throw new RuntimeException("Test failed");
    }
    public static void main(String[] args) throws Exception {
        TestPLSolution sol = new TestPLSolution();
        sol.testParkingLot();
    }
}

