package OOD.RestaurantReservationSystem;

import java.util.Date;

public class Party {
    private int capacity;
    private Date startTime;
    private Date endTime;

    public Party(int capacity, Date startTime, Date endTime) {
        this.capacity = capacity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

}
