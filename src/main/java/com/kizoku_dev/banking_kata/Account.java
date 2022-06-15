package com.kizoku_dev.banking_kata;

import com.kizoku_dev.banking_kata.exception.DepositException;
import com.kizoku_dev.banking_kata.exception.OperationException;
import com.kizoku_dev.banking_kata.exception.WithdrawException;

/**
 * The type Account.
 */
public class Account {

    private final Statement statement;
    private double balance;

    /**
     * Instantiates a new Account.
     *
     * @param balance the initial balance
     */
    public Account(double balance) {
        this.balance = balance;
        this.statement = new Statement();
    }

    private void validateMoneyValue(double money) throws OperationException {
        if (this.balance + money < 0) {
            throw new OperationException(OperationException.NOT_ENOUGH_MONEY);
        }
        if (money != 0) {
            return;
        }
        throw new OperationException(OperationException.ZERO_VALUE);
    }

    /**
     * Deposit money.
     *
     * @param money the money to add to balance
     */
    public void deposit(double money) throws DepositException {
        try {
            validateMoneyValue(money);
        } catch (OperationException e) {
            throw new DepositException(e);
        }
        this.balance = statement.addRecord(money, this.balance);
    }

    /**
     * Withdraw money.
     *
     * @param money the money to withdraw
     * @throws OperationException the withdraw exception
     */
    public void withdraw(double money) throws WithdrawException {
        try {
            validateMoneyValue(0 - money);
        } catch (OperationException e) {
            throw new WithdrawException(e);
        }
        this.balance = statement.addRecord(0 - money, this.balance);
    }

    /**
     * Gets balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    public Statement getStatement() {
        return this.statement;
    }
}
