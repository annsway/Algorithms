package OOD.HotelReservationSystem;

import java.util.*;

public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;
    private Map<Room, Set<Reservation>> roomReservations;

    public HotelReservationSystem() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.roomReservations = new HashMap<>();
    }

    /**
     * Use Case #1: Search for available rooms
     * steps:
     * - gather search criteria
     * - iterate rooms to get available rooms
     * return:
     * - SINGLE room: 20
     * - DOUBLE room: 10
     */
    public Map<RoomType, Integer> search(Request req) {
        Map<RoomType, Integer> searchResult = new HashMap<>();
        for (Room room : rooms) {
            Set<Reservation> schedule = roomReservations.get(room);
            if (isRequestAvailable(req, schedule)) {
                RoomType roomType = room.getType();
                searchResult.put(roomType, searchResult.getOrDefault(roomType, 0) + 1);
            }
        }
        return searchResult;
    }

    private boolean isRequestAvailable(Request req, Set<Reservation> schedule) {
        if (schedule == null || schedule.size() == 0) {
            return true;
        }
        long checkInDate = req.getCheckInDate().getTime();
        long checkOutDate = req.getCheckOutDate().getTime();

        // if there's any existing reservation conflicts with the search criteria, return false
        for (Reservation r : schedule) {
            long startDate = r.getCheckInDate().getTime();
            long endDate = r.getCheckOutDate().getTime();
            if ((checkInDate >= startDate && checkInDate <= endDate) ||
                    (checkOutDate >= startDate && checkOutDate <= endDate)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Use Case #2: Make Reservation
     * steps:
     * - get the available rooms
     * - if yes, confirm reservation and update rooms
     * - if no, throw exception
     */
    public Reservation makeReservation(ReservationRequest req) throws NoAvailableRoomsException {
        Reservation reservation = new Reservation(req);
        Map<RoomType, Integer> roomsNeeded = req.getRoomsNeeded();
        for (Room room : rooms) {
            RoomType type = room.getType();
            int count = roomsNeeded.get(type);
            if (roomsNeeded.containsKey(type) && count > 0) {
                Set<Reservation> schedule = roomReservations.get(room);
                if (isRequestAvailable(req, schedule)) {
                    reservation.addRoom(room);
                    count--;
                    roomsNeeded.put(type, count);
                    if (!roomReservations.containsKey(room)) {
                        roomReservations.put(room, new HashSet<>());
                    }
                    roomReservations.get(room).add(reservation);
                }
            }
        }
        for (Integer count : roomsNeeded.values()) {
            if (count > 0) {
                throw new NoAvailableRoomsException();
            }
        }
        return reservation;
    }

    /** Cancel reservation
     * Steps:
     * - check if reservation is valid
     * - cancel the input reservation; update roomReservation
     * */
    public void cancelReservation(Reservation reservation) throws InvalidReservationException {
        if (!validReservation(reservation)) {
            throw new InvalidReservationException();
        }
        // cancel each room in the reservation
        Date checkInDate = reservation.getCheckInDate();
        Date checkOutDate = reservation.getCheckOutDate();
        for (Room room : reservation.getRooms()) {
            Set<Reservation> reservationList = roomReservations.get(room);
            // only cancel the dates that match with the input reservation
            for (Reservation r : reservationList) {
                if (r.getCheckInDate() == checkInDate && r.getCheckOutDate() == checkOutDate) {
                    reservationList.remove(r);
                }
            }
        }
    }

    private boolean validReservation(Reservation reservation) {
        for (Reservation r : reservations) {
            // if dates and rooms are equal
            if (r.getCheckInDate() == reservation.getCheckInDate() &&
            r.getCheckOutDate() == reservation.getCheckOutDate()) {
                if (r.getRooms().equals(reservation.getRooms())) {
                    return true;
                }
            }
        }
        return false;
    }
}
