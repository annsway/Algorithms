package OOD.RestaurantReservationSystem;

public class Reservation {
    private Table table;
    private int startTime;

    public Reservation(Table table, int startTime) {
        this.table = table;
        this.startTime = startTime;
    }

    public Table getTable() {
        return this.table;
    }

    public int getTime() {
        return this.startTime;
    }
}
