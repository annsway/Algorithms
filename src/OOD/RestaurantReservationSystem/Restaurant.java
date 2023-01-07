package OOD.RestaurantReservationSystem;

import java.util.*;

public class Restaurant {
    private List<Table> tables;
    private List<Meal> menu;
    private Map<Table, List<Order>> orders;
    private Map<Table, List<Integer>> reservations;

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

    public Table findTable(Party party) throws NoTableException {
        for (Table table : tables) {
            if (table.isAvailable() && table.getCapacity() >= party.getCapacity()) {
                table.markUnavailable();
                orders.put(table, new ArrayList<>()); // add new order
                return table;
            }
        }
        throw new NoTableException(party);
    }

    public void takeOrder(Table table, Order order) {
        table.setOrder(order);
    }

    public float checkout(Table t) {
        float bill = 0;
        if (t.getCurrentOrder() != null) {
            bill = t.getCurrentOrder().getBill();
        }
        t.markAvailable();
        t.setOrder(null);
        return bill;
    }

    public Reservation findTableForReservation(int startTime) throws NoTableForReservationException {
        for (Table table : tables) {
            if (table.isAvailable()) {
                int len = reservations.size();
                if (reservations.get(table).get(len - 1) < startTime) {
                    Reservation r = new Reservation(table, startTime);
                    return r;
                } else {
                    // TODO
                }

            }
        }
        throw new NoTableForReservationException(startTime);
    }

    public void confirmReservation(Reservation r) {
        // TODO
    }

    public void cancelReservation(Reservation r) {
        // TODO
    }
}
