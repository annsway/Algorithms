package OOP;

public class InterestAccount extends Account {
    double interestRate;

    public InterestAccount(double balance, String number, double interestRate) {
        super(balance, number);
        this.interestRate = interestRate;
    }
    public void accrueInterest() {
        super.balance *= 1 + this.interestRate;
    }

    @Override
    public void printStatement() {
        System.out.println("This is InterestAccount");
    }
}

class polyTest {
    public static void main(String[] args) {
        Account b = new Account(100, "TK-710");
//        b.accrueInterest(); // won't compile
        b.printStatement(); // uses printStatement method from Account class
    }
}