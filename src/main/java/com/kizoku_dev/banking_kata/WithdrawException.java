package com.kizoku_dev.banking_kata;

public class WithdrawException extends Exception {

    public static final String NOT_ENOUGH_MONEY = "Balance is not sufficient to perform the withdrawal.";

    public WithdrawException(String message) {
        super(message);
    }
}
