package bankAccEx;

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
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.printf("Account ID%s created%n", account.getId());
                    break;
                case "Deposit":
                    executeDepositCommand(accounts, commandArgs);
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(commandArgs[1]));
                    break;
                case "GetInterest":
                    executeGetInterestCommand(accounts, commandArgs);
                    break;
            }
            command = reader.readLine();
        }
    }



    private static void executeGetInterestCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            int years = Integer.parseInt(commandArgs[2]);
            BankAccount account = accounts.get(id);
            double interest = account.getInterestRate(years);
            System.out.printf("%.2f", interest);
            System.out.println();
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] commandArgs) {
        int id = Integer.parseInt(commandArgs[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            double amount = Integer.parseInt(commandArgs[2]);
            BankAccount account = accounts.get(id);
            account.deposit(amount);
            System.out.printf("Deposited %.0f to %s%n", amount, account);
        }
    }
}

/*
Input 1:
Create
Deposit 1 20
GetInterest 1 10
End



Expected output 1:
Account ID1 created
Deposited 20 to ID1
4.00



Input 2:
Create
Create
Deposit 1 20
Deposit 3 20
Deposit 2 10
SetInterest 1
GetInterest 1 1
GetInterest 2 1
GetInterest 3 1
End



Expected output 2:
Account ID1 created
Account ID2 created
Deposited 20 to ID1
Account does not exist
Deposited 10 to ID2
20.00
10.00
Account does not exist



 */
