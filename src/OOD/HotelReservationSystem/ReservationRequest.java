package OOD.HotelReservationSystem;

import java.util.Date;
import java.util.Map;

public class ReservationRequest extends Request {
    @Override
    public Date getCheckInDate() {
        return checkInDate;
    }

    @Override
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Map<RoomType, Integer> getRoomsNeeded() {
        return roomsNeeded;
    }

    private Date checkInDate;
    private Date checkOutDate;
    private Map<RoomType, Integer> roomsNeeded;

    public ReservationRequest(Date checkInDate, Date checkOutDate, Map<RoomType, Integer> roomsNeeded) {
        super(checkInDate, checkOutDate);
        this.roomsNeeded = roomsNeeded;
    }
}
