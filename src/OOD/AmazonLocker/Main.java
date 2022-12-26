package OOD.AmazonLocker;

/** Requirements:
 An Amazon Locker pickup location has a series of lockers for packages to be dropped off and picked up.
 Packages can come in many different sizes. We have lockers of varying sizes as well.
 Model the lockers, packages, and pickup locations. Implement an algorithm for efficiently finding the
 best possible empty locker for a given package.
 *
 * Use cases:
 * - A newly packaged box can find an available locker to place itself
 * - A customer can pick up her package
 *
 * APIs:
 * - public PickupLocation findPickupLocation(Package package)
 * - public Locker deliver(Package package)
 * - public Package pickup(Locker locker)
 * */
public class Main {
    public static void main(String[] args) {
        PickupLocation loc1 = new PickupLocation("600 Kirkland", 9);
        PickupLocation loc2 = new PickupLocation("800 Washington", 10);

        // packages
        Package s1 = new SmallPackage();
        Package m1 = new MediumPackage();
        Package l1 = new LargePackage();

//        System.out.println(loc1.hasLocker(s1));
//        System.out.println(loc1.hasLocker(m1));
//        System.out.println(loc1.hasLocker(l1));

//        System.out.println(loc1.deliver(s1));

        for (int i = 0; i < 4; i++) {
            Package p = new LargePackage();
//            loc1.deliver(p);
            System.out.println(loc1.deliver(p));
        }

        System.out.println("deliver s1: " + loc1.deliver(s1));
        // pick up s1
        System.out.println("pick up s1: " + loc1.pickup(s1));
    }
}
