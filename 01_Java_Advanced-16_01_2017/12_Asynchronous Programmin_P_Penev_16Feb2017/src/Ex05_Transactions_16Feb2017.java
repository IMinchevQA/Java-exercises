import java.io.IOException;

public class Ex05_Transactions_16Feb2017 {
    public static void main(String[] args) throws InterruptedException, IOException {

        BankAccount account = new BankAccount();
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                account.deposit(1);
            }
        };

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(account.balance);
    }
}

class BankAccount {
    int balance;

    synchronized void deposit(int amount) {
            balance = balance + amount;

    }
}
