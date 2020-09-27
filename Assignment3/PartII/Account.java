
public class Account {
    private static int nextId = 0;
    private int id = ++nextId;
    private double balance;

    public Account() {

    }

    public Account(double startingBalance) {
        this.balance = startingBalance;
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }

}
