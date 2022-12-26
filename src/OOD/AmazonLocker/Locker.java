package OOD.AmazonLocker;

public class Locker {
    private final PackageSize lockerSize;
    private Package currentPackage;

    public Locker(PackageSize size) {
        this.lockerSize = size;
    }

    public void deliver(Package p) {
        this.currentPackage = p;
    }

    public boolean pickup(Package p) {
        if (this.currentPackage == p) {
            this.currentPackage = null;
            return true;
        }
        return false;
    }

    public Package getPackage() {
        return currentPackage;
    }

    public boolean fit(Package p) {
//        System.out.println(this.currentPackage);
        return this.currentPackage == null && this.lockerSize.getSize() >= p.getSize().getSize();
    }
}
