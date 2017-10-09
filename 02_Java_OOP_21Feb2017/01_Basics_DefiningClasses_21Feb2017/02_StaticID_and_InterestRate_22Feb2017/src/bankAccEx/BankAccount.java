package bankAccEx;

/**
 * Created by Ivan Minchev on 2/22/2017.
 */
public class BankAccount {

    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static int accountsCount;
    private static double currentInterestRate;

    private int id;
    private double balance;

    public BankAccount() {
        //accountsCount value is incremented first.
        //Then id takes already incremented accountsCount value.
        //Why? - Because initial default "int" value is 0 so the first id we have will be equal to 1;
       this.id = ++accountsCount;
       currentInterestRate = DEFAULT_INTEREST_RATE;
    }

    public int getId() {
        return this.id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return this.balance * currentInterestRate * years;
    }

    public static void setInterestRate(double interestRate) {
        currentInterestRate = interestRate;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
