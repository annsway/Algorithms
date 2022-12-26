package OOD.AmazonLocker;

abstract class Package {
    public abstract PackageSize getSize();
}

class SmallPackage extends Package {
    @Override
    public PackageSize getSize() {
        return PackageSize.Small;
    }
}

class MediumPackage extends Package {
    @Override
    public PackageSize getSize() {
        return PackageSize.Medium;
    }
}

class LargePackage extends Package {
    @Override
    public PackageSize getSize() {
        return PackageSize.Large;
    }
}