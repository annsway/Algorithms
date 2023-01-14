package OOD.RestaurantReservationSystem;

import java.util.*;

public class Restaurant {
    private List<Table> tables;
    private List<Meal> menu;
    private Map<Table, List<Order>> orders;
    private Map<Table, List<Reservation>> reservations;

    public Restaurant() {
        this.tables = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.tables.add(new Table(4, true));
        }
        for (int i = 5; i < 10; i++) {
            this.tables.add(new Table(10, true));
        }

        this.menu = new ArrayList<>();
        float price = 10;
        for (int i = 20; i < 10; i++) {
            this.menu.add(new Meal((float) (price * 1.05)));
        }

        this.orders = new HashMap<>();
        this.reservations = new HashMap<>();
    }

    public Table findTable(Party party) throws NoTableException, NoTableForReservationException {
        for (Table table : tables) {
            if (table.isAvailable() && table.getCapacity() >= party.getCapacity()) {
                Reservation r = findTableForReservation(table, party.getStartTime(), party.getEndTime());
                // find available table for reservation confirm
                confirmReservation(r);
                return table;
            }
        }
        throw new NoTableException(party);
    }

    private Reservation findTableForReservation(Table table, Date startTime, Date endTime) throws NoTableForReservationException {
        // assume the requested time slot is valid (within business hours)
        // check if the given table is available during the requested time slot
        List<Reservation> listOfReservations = reservations.get(table);
        if (listOfReservations == null || listOfReservations.size() == 0) {
            return new Reservation(table, startTime, endTime);
        }
        Collections.sort(listOfReservations, new Comparator<>(){
            @Override
            public int compare(Reservation r1, Reservation r2) {
                if (r1.getStartTime() == r2.getStartTime()) {
                    return (int)(r1.getEndTime().getTime() - r2.getEndTime().getTime());
                }
                return (int)(r1.getStartTime().getTime() - r2.getStartTime().getTime());
            }
        });
        // listOfReservations is sorted by startTime, endTime
        int len = listOfReservations.size();
        for (int i = 0; i < len; i++) {
            Reservation r = listOfReservations.get(i);
            if (i == 0 && endTime.getTime() < r.getStartTime().getTime()) {
                return new Reservation(table, startTime, endTime);
            } else if (i == len - 1) {
                if (startTime.getTime() > r.getEndTime().getTime()) {
                    return new Reservation(table, startTime, endTime);
                };
            } else {
                Reservation nextRev = listOfReservations.get(i + 1);
                if (r.getEndTime().getTime() < startTime.getTime()
                        && endTime.getTime() < nextRev.getStartTime().getTime()) {
                    return new Reservation(table, startTime, endTime);
                }
            }
        }
        throw new NoTableForReservationException(startTime, endTime);
    }

    // only when customers arrived, can they make an order
    public void takeOrder(Table table, Order order) {
        table.setOrder(order);
        if (!orders.containsKey(table)) {
            orders.put(table, new ArrayList<>());
        }
        orders.get(table).add(order);
    }

    public double checkout(Table t) {
        double bill = 0;
        if (t.getCurrentOrder() != null) {
            bill = t.getCurrentOrder().getBill();
        }
        t.markAvailable();
        t.setOrder(null);
        return bill;
    }

    public void confirmReservation(Reservation r) {
        Table table = r.getTable();
        if (!reservations.containsKey(table)) {
            reservations.put(table, new ArrayList<>());
        }
        reservations.get(table).add(r);
    }

    public void cancelReservation(Reservation r) {
        Table table = r.getTable();
        List<Reservation> listOfReservations = reservations.get(table);
        listOfReservations.remove(r);
    }
}
