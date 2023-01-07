package OOD.HotelReservationSystem;

import java.util.*;

public class Reservation {
    private Date checkInDate;
    private Date checkOutDate;
    private Set<Room> rooms;

    Reservation(ReservationRequest q) {
        this.checkInDate = q.getCheckInDate();
        this.checkOutDate = q.getCheckOutDate();
        this.rooms = new HashSet<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Set<Room> getRooms() {
        return rooms;
    }
}
