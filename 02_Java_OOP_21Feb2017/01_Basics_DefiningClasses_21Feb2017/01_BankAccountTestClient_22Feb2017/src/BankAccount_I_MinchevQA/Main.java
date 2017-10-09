import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/**
 * Created by Ivan Minchev on 2/22/2017.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        while (!"End".equals(command)) {

            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "Create":
                    executeCreateCommand(accounts, commandArgs[1]);
                    break;
                case "Deposit":
                    executeDepositCommand(accounts, commandArgs);
                    break;
                case "Withdraw":
                    executeWithdrawCommand(accounts, commandArgs);
                    break;
                case "Print":
                    executePrintCommand(accounts, commandArgs[1]);
                    break;
            }
            command = reader.readLine();
        }
    }

    private static void executePrintCommand(HashMap<Integer, BankAccount> accounts, String commandArg) {
        int id = Integer.parseInt(commandArg);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        BankAccount account = accounts.get(id);
        System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
    }

    private static void executeWithdrawCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        try {
            accounts.get(id).withdraw(amount);
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);

        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }

        try {
            accounts.get(id).deposit(amount);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }


    private static void executeCreateCommand(HashMap<Integer, BankAccount> accounts, String commandArg) {
        int id = Integer.valueOf(commandArg);
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}

/*
Input 1:
Create 1
Create 1
Deposit 1 20
Withdraw 1 30
Withdraw 1 10
Print 1
End


Expected output 1:
Account already exists
Insufficient balance
Account ID1, balance 10.00


Input 2:
Create 1
Deposit 2 20
Withdraw 2 30
Print 2
End


Expected output 2:
Account does not exist
Account does not exist
Account does not exist


 */
