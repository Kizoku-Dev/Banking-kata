package com.kizoku_dev.banking_kata.exception;

public class WithdrawException extends OperationException {

    private static final String WITHDRAW = "withdraw";

    public WithdrawException(Exception e) {
        super(String.format(e.getMessage(), WITHDRAW));
    }
}
