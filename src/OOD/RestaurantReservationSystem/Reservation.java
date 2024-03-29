package OOD.RestaurantReservationSystem;

import java.util.Date;

public class Reservation {
    private Table table;

    private Date startTime;
    private Date endTime;

    public Reservation(Table table, Date startTime, Date endTime) {
        this.table = table;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Table getTable() {
        return this.table;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
