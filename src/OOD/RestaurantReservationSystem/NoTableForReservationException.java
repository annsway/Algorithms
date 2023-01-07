package OOD.RestaurantReservationSystem;

public class NoTableForReservationException extends Exception {
    public NoTableForReservationException(int time) {
        super("No table for reservation time period: " + time);
    }
}
