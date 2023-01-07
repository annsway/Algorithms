package OOD.HotelReservationSystem;

public class Room {
    private RoomType size;
    private boolean isAvailable;

    public Room(RoomType size, boolean isAvailable) {
        this.size = size;
        this.isAvailable = isAvailable;
    }

    public RoomType getType() {
        return this.size;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
}
