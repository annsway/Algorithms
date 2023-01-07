package OOD.RestaurantReservationSystem;

public class NoTableException extends Exception {
    public NoTableException(Party party) {
        super("No table available for party size: " + party.getCapacity());
    }
}
