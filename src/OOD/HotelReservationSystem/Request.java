package OOD.HotelReservationSystem;

import java.util.Date;

public class Request {
    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    private Date checkInDate;
    private Date checkOutDate;

    public Request(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

}
