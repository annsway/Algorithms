package OOD.AmazonLocker;

public enum PackageSize {
    Small(1),
    Medium(2),
    Large(3);

    private final int size;

    // constructor
    PackageSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
