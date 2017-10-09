package models;

public class BankAccount {
    private double balance;

    public void deposit(double depositValue) {
        if (depositValue <= 0) {
            throw new  IllegalArgumentException ("Deposit value must be positive!");
        }
        this.balance += depositValue;
    }

    public Double getBalance() {
        return this.balance;
    }
}
