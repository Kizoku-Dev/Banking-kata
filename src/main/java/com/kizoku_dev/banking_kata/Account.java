package com.kizoku_dev.banking_kata;

/**
 * The type Account.
 */
public class Account {

    private double balance;

    /**
     * Instantiates a new Account.
     *
     * @param balance the initial balance
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * Deposit money.
     *
     * @param money the money to add to balance
     */
    public void deposit(double money) {
        this.balance = this.balance + money;
    }

    /**
     * Withdraw money.
     *
     * @param money the money to withdraw
     * @throws WithdrawException the withdraw exception
     */
    public void withdraw(double money) throws WithdrawException {
        double newBalance = this.balance - money;
        if (newBalance < 0) {
            throw new WithdrawException(WithdrawException.NOT_ENOUGH_MONEY);
        }
        this.balance = newBalance;
    }

    /**
     * Gets balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }
}
