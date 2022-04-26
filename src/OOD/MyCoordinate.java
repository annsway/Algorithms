package OOD;

public class MyCoordinate {
    int x;
    int y;

    public MyCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        MyCoordinate obj = (MyCoordinate) o;
        return this.x == obj.x && this.x == obj.y;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = this.x * prime + this.y * prime * prime;
        return result;
    }

    public static void main(String[] args) {
        MyCoordinate c1 = new MyCoordinate(1, 1);
        MyCoordinate c2 = new MyCoordinate(1, 1);
        System.out.println(c1 == c2); // false
        System.out.println(c1.equals(c2)); // true
        System.out.println(c1.hashCode() == c2.hashCode()); // true

    }
}
