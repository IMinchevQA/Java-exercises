
/**
 * Created by Ivan Minchev on 2/22/2017.
 */
public class BankAccount {
    private int id;
    private double balance;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non-negative");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
