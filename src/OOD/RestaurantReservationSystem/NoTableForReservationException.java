package OOD.RestaurantReservationSystem;

import java.util.Date;

public class NoTableForReservationException extends Exception {
    public NoTableForReservationException(Date startTime, Date endTime) {
        super("No table for reservation time period: " + startTime.getTime() + " to " + endTime);
    }
}
