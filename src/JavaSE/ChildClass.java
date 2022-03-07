package JavaSE;

public class ChildClass extends ParentClass {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        double calWeight = childClass.weight * 10;
//        int calPrice = childClass.price * 10; // compile error
    }
}
