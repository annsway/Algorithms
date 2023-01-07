package OOD.HotelReservationSystem;

public class NoAvailableRoomsException extends Exception {
    public NoAvailableRoomsException() {
        super("No rooms are available for your request");
    }
}
