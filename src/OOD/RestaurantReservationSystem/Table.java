package OOD.RestaurantReservationSystem;

public class Table {
    private boolean available;
    private final int capacity;
    private Order curOrder;

    public Table(int capacity, boolean available) {
        this.capacity = capacity;
        this.available = available;
        this.curOrder = null;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public void markAvailable() {
        this.available = true;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setOrder(Order order) {
        if (this.curOrder == null) {
            this.curOrder = order;
        } else {
            this.curOrder.mergeOrder(order);
        }
    }

    public Order getCurrentOrder() {
        return this.curOrder;
    }

}
