package OOP;

public class Calculator {

    public int plus(double x, double y) {
        return (int)(x + y);
    }

    // test overloading
//    public double plus(double x, double y) {
//        return x + y;
//    }

    public static void main(String[] args) {
        boolean b = true;
        boolean c = false;
        boolean d = false;

        if (b || (c && d)) {
            System.out.println("inside");
        }

    }
}
/**
 * I realized its left to right so b is evaluated first and then the (c&&d) and then e
 * */