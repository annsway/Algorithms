package OOP;

public class Account {
    double balance;
    String number;
    public Account(double balance, String number) {
        this.balance = balance;
        this.number = number;
    }
    public double credit(double num) {
        this.balance -= num;
        return this.balance;
    }
    public void printStatement() {
        System.out.println("this is Account");
    }
}
