package tests;

import models.BankAccount;
import org.junit.Assert;
import org.junit.Test;

public class BankAccountTests {

    @Test
    public void testDepositBankAccount() {
        Assert.assertTrue(true);
    }

    @Test
    public void depositShouldAddMoney() {
        BankAccount account = new BankAccount();
        account.deposit(50);
        Assert.assertTrue(account.getBalance() == 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositNegativeShouldNotAddMoney() {
        BankAccount account = new BankAccount();
        account.deposit(-50);
    }




}

