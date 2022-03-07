package OOP;

public class IntBox {
    // example of "boxing"
    private int contents;

    public void put(int t) {
        contents = t;
    }

    public int get() {
        return contents;
    }
}

class Box<T> {
    private T contents;

    public Box(T t) {
        put(t);
    }

    public void put(T t) {
        contents = t;
    }

    public T get() {
        return contents;
    }
}

class BoxTesting {
    public static void main(String[] args) {
//        Box<int> b = new Box<int>(); // WRONG! <> => cannot be primitive type
        Box<Double> bd = new Box<Double>(1.0);
    }
}

