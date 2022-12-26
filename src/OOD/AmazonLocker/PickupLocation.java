package OOD.AmazonLocker;

public class PickupLocation {
    private final Locker[] listOfLockers;
    private String address;

    public PickupLocation(String address, int numLockers) {
        this.listOfLockers = new Locker[numLockers];
        this.address = address;
        for (int i = 0; i < numLockers / 3; i++) {
            listOfLockers[i] = new Locker(PackageSize.Small);
        }
        for (int i = numLockers / 3; i < numLockers * 2 / 3; i++) {
            listOfLockers[i] = new Locker(PackageSize.Medium);
        }
        for (int i = numLockers * 2 / 3; i < numLockers; i++) {
            listOfLockers[i] = new Locker(PackageSize.Large);
        }
    }

    public boolean hasLocker(Package p) {
        for (Locker locker : listOfLockers) {
            if (locker.fit(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean deliver(Package p) {
        for (Locker locker : listOfLockers) {
            if (locker.fit(p)) {
                locker.deliver(p);
                return true;
            }
        }
        return false;
    }

    public boolean pickup(Package p) {
        for (Locker locker : listOfLockers) {
            if (locker.pickup(p)) {
                return true;
            }
        }
        return false;
    }
}
