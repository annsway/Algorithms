package OOP;

public class InnerClassDemo {
    public static void main(String[] args) {
        People ann = new People("ann");
        People.Bike annBike = ann.new Bike();
        annBike.printName();
    }
}

class People {
    String name;
    People(String name) {
        this.name = name;
    }
    // inner class (non-static nested class)
    class Bike {
        String owner = name;
        People p = People.this;
        void printName() {
            System.out.println("Inside People.Bike inner class");
            System.out.println(name == p.name);
        }
    }
}