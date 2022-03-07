package Hash;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Coordinate) {
            Coordinate o1 = (Coordinate) o;
            return this.x == o1.x && this.y == o1.y;
        }
        return false;
    }
    public int hashCode() {
        // rolling hash
        return this.x * 31 * 31 + this.y * 31;
    }

    public static void main(String[] args) {
//        String s = "abc";
//        s.equals("ab");
//        s.hashCode();
        Coordinate o1 = new Coordinate(1, 1);
        Coordinate o2 = new Coordinate(1, 1);

/**
 * case 1: Neither equals() nor hashCode() was overrode. (Call the equals() and hashCode() functions in Object class)
 * o1.equals(o2) = false
 * o1's hash code is 531885035
 * o2's hash code is 1418481495
 * ******************
 * ******************
 * case 2: Override equals(), but NOT override hashCode()
 * o1.equals(o2) = true
 * o1's hash code is 531885035
 * o2's hash code is 1418481495
 *
 * 可以看到equals相等但是hashcode不一定相等；这是因为不重写hashcode，那么Student类的hashcode方法就是Object默认的hashcode方法，
 * 由于默认的hashcode方法是根据对象的内存地址经哈希算法得来的，显然此时s1!=s2,故两者的hashcode不一定相等。
 * 这就不符合：如果两个对象相同（即用equals比较返回true），那么它们的hashCode值一定要相同。
 * 所以重写equals的同时也要重写hashcode。
 * ******************
 * ******************
 * case 3: Both equals() and hashCode() were overrode.
 * o1.equals(o2) = true
 * o1's hash code is 992
 * o2's hash code is 992
 */

        System.out.println("o1.equals(o2) = " + o1.equals(o2));
        System.out.println("o1's hash code is " + o1.hashCode());
        System.out.println("o2's hash code is " + o2.hashCode());

    }
}
