package com.kizoku_dev.banking_kata.exception;

public class DepositException extends OperationException {

    private static final String DEPOSIT = "deposit";

    public DepositException(Exception e) {
        super(String.format(e.getMessage(), DEPOSIT));
    }
}
