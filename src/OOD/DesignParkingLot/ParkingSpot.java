package OOD.DesignParkingLot;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;  // null if no vehicle parks inside

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    public void park(Vehicle v) {
        currentVehicle = v;
    }

    public void leave() {
        currentVehicle = null;
    }

    public Vehicle getVehicle() {
        return currentVehicle;
    }

    // other
    boolean fit(Vehicle v) {
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
    }
}