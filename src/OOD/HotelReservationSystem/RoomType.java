package OOD.HotelReservationSystem;

public enum RoomType {
    SINGLE(1),
    DOUBLE(2);

    private final int size;

    RoomType(int size){
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}